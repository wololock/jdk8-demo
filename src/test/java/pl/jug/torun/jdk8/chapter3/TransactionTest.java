package pl.jug.torun.jdk8.chapter3;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TransactionTest {

    private Person marian = Person.create("Marian", LocalDate.of(1956, 3, 5));
    private Person anna = Person.create("Anna", LocalDate.of(1977, 10, 3));
    private Person andrzej = Person.create("Andrzej", LocalDate.of(1992, 12, 24));

    private List<Transaction> transactions;

    @Before
    public void setup() {
        transactions = new LinkedList<>(Arrays.asList(
                new Transaction(marian, BigDecimal.valueOf(99.99), LocalDateTime.now().minusDays(3)),
                new Transaction(marian, BigDecimal.valueOf(10.00), LocalDateTime.now().minusDays(2)),
                new Transaction(marian, BigDecimal.valueOf(3.99)),
                new Transaction(anna, BigDecimal.valueOf(56.22)),
                new Transaction(andrzej, BigDecimal.valueOf(25.00), LocalDateTime.now().minusWeeks(2)),
                new Transaction(andrzej, BigDecimal.valueOf(20.00), LocalDateTime.now().minusHours(11))
        ));
    }

    @Test
    public void countAllMariansTransactions() {
        //when:
        Integer numberOfTransactions = transactions.stream()
                .filter(transaction -> transaction.getTrader().equals(marian))
                .mapToInt(t -> 1)
                .sum();

        //then:
        assertThat(numberOfTransactions, is(equalTo(3)));
    }

    @Test
    public void findTheHighestTransactionAmount() {
        //when:
        Optional<BigDecimal> highestAmount = transactions.stream()
                .map(Transaction::getAmount)
                .max(Comparator.<BigDecimal>naturalOrder());

        //then:
        assertThat(highestAmount.get(), is(equalTo(BigDecimal.valueOf(99.99))));
    }

    @Test
    public void findTraderWithTheHighestAmountWeekAgo() {
        //when:
        Optional<Transaction> bestTransaction = transactions.stream()
                .filter(transaction -> transaction.getCreateDate().isBefore(LocalDateTime.now().minusWeeks(1)))
                .max(Comparator.comparing(transaction -> transaction.getAmount()));

        //then:
        assertThat(bestTransaction.get().getTrader(), is(equalTo(andrzej)));
    }

    @Test
    public void groupTransactionsByTrader() {
        //when:
        Map<Person, List<Transaction>> groupedTransactions = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getTrader));

        //then:
        assertThat(groupedTransactions.keySet().containsAll(Arrays.asList(andrzej, marian, anna)), is(equalTo(true)));
    }

    @Test
    public void getListOfTransactionsLowerThan30() {
        //when:
        List<Transaction> filteredTransactions = transactions.stream()
                .filter(transaction -> transaction.getAmount().compareTo(BigDecimal.valueOf(30.00)) < 0)
                .collect(Collectors.toList());

        filteredTransactions.forEach(transaction -> {
            System.out.println(transaction);
        });

        //then:
        assertThat(filteredTransactions.size(), is(equalTo(4)));
    }

    @Test
    public void checkIfAllTransactionsWereHigherThan5() {
        //then:
        boolean test = transactions.stream()
                .allMatch(transaction -> transaction.getAmount().compareTo(BigDecimal.valueOf(5.0)) < 0);

        //then:
        assertThat(test, is(equalTo(false)));
    }

    @Test
    public void findTheOldestTransaction() {
        //when:
        Optional<Transaction> oldestTransaction = transactions.stream()
                .collect(Collectors.minBy(
                                Comparator.comparing(Transaction::getCreateDate))
                );


        //then:
        assertThat(oldestTransaction.get().getTrader(), is(equalTo(andrzej)));
        assertThat(oldestTransaction.get().getAmount(), is(equalTo(BigDecimal.valueOf(25.0))));
    }

    @Test
    public void sumAllTransactionsAmount() {
        //when:
        BigDecimal transactionsAmountSum = transactions.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal expected = BigDecimal.valueOf(215.20).setScale(2, RoundingMode.HALF_DOWN);

        //then:
        assertThat(transactionsAmountSum, is(equalTo(expected)));
    }

    @Test
    public void sumAllAndrzejsTransactionsAmount() {
        //when:
        BigDecimal transactionsAmountSum = transactions.stream()
                .filter(transaction -> transaction.getTrader().equals(andrzej))
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal expected = BigDecimal.valueOf(45.0).setScale(2, RoundingMode.HALF_DOWN);

        //then:
        assertThat(transactionsAmountSum, is(equalTo(BigDecimal.valueOf(45.0))));
    }

}

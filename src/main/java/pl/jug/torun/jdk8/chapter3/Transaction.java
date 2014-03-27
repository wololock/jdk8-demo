package pl.jug.torun.jdk8.chapter3;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Person trader;

    private BigDecimal amount;

    private LocalDateTime createDate = LocalDateTime.now();

    public Transaction(Person person, BigDecimal amount, LocalDateTime createDate) {
        this(person, amount);
        this.createDate = createDate;
    }

    public Transaction(Person trader, BigDecimal amount) {
        this.trader = trader;
        this.amount = amount;
    }

    public Person getTrader() {
        return trader;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return String.format("Transaction {trader=%s, amount=%s, createDate=%s}", trader.toString(), amount.toString(), createDate.toString());
    }
}

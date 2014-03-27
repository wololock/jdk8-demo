package pl.jug.torun.jdk8.example.person;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import pl.jug.torun.jdk8.chapter3.Person;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class GuavaPersonRepository implements PersonRepository {

    @Override
    public List<Person> findAllWithMinimalAge(Integer age) {
        LocalDate maxBirthDate = LocalDate.now().minusYears(age);

        Collection<Person> filtered = Collections2.filter(findAll(), new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return person.getBirthDate().isBefore(maxBirthDate);
            }
        });

        return new LinkedList<>(filtered);
    }

    @Override
    public List<String> convertToListOfNames(List<Person> people) {
        Collection<String> converted = Collections2.transform(people, new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        });

        return new LinkedList<>(converted);
    }
}

package pl.jug.torun.jdk8.example.person;

import pl.jug.torun.jdk8.chapter3.Person;
import pl.jug.torun.jdk8.example.repository.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface PersonRepository extends Repository<Person> {

    default List<Person> findAll() {
        return Arrays.asList(
                new Person("Robert C. Martin", LocalDate.of(1952, 5, 29)),
                new Person("Martin Fowler", LocalDate.of(1963, 9, 12)),
                new Person("Kent Beck", LocalDate.of(1961, 5, 5)),
                new Person("Ward Cunningham", LocalDate.of(1949, 5, 26)),
                new Person("Erich Gamma", LocalDate.of(1961, 7, 2))
        );
    }

    List<Person> findAllWithMinimalAge(Integer age);

    List<String> convertToListOfNames(List<Person> people);
}

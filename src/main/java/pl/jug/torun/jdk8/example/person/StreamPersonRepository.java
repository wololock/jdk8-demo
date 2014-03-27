package pl.jug.torun.jdk8.example.person;

import pl.jug.torun.jdk8.chapter3.Person;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPersonRepository implements PersonRepository {

    @Override
    public List<Person> findAllWithMinimalAge(Integer age) {
        LocalDate maxBirthDate = LocalDate.now().minusYears(age);
        return findAll().stream()
                .filter(person -> person.getBirthDate().isBefore(maxBirthDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> convertToListOfNames(List<Person> people) {
        return people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }
}

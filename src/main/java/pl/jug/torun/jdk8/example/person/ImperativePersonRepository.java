package pl.jug.torun.jdk8.example.person;

import pl.jug.torun.jdk8.chapter3.Person;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ImperativePersonRepository implements PersonRepository {

    @Override
    public List<Person> findAllWithMinimalAge(Integer age) {
        LocalDate maxBirthDate = LocalDate.now().minusYears(age);

        List<Person> filteredPeople = new LinkedList<>();

        for (Person person : findAll()) {
            if (person.getBirthDate().isBefore(maxBirthDate)) {
                filteredPeople.add(person);
            }
        }

        return filteredPeople;
    }

    @Override
    public List<String> convertToListOfNames(List<Person> people) {
        List<String> namesList = new LinkedList<>();
        for (Person person : people) {
            namesList.add(person.getName());
        }
        return namesList;
    }
}

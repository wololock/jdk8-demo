package pl.jug.torun.jdk8.example.person;

import org.junit.Before;
import org.junit.Test;
import pl.jug.torun.jdk8.chapter3.Person;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class PersonRepositoryTest {

    private List<String> peopleNames = Arrays.asList(
            "Robert C. Martin",
            "Martin Fowler",
            "Kent Beck",
            "Ward Cunningham",
            "Erich Gamma"
    );

    private ImperativePersonRepository imperativePersonRepository;

    private GuavaPersonRepository guavaPersonRepository;

    private StreamPersonRepository streamPersonRepository;

    @Before
    public void setup() {
        imperativePersonRepository = new ImperativePersonRepository();
        guavaPersonRepository = new GuavaPersonRepository();
        streamPersonRepository = new StreamPersonRepository();
    }


    @Test
    public void shouldConvertPersonListToStringNamesList() {
        List<Person> allPeople = imperativePersonRepository.findAll();

        assertThat(imperativePersonRepository.convertToListOfNames(allPeople), is(equalTo(peopleNames)));

        assertThat(guavaPersonRepository.convertToListOfNames(allPeople), is(equalTo(peopleNames)));

        assertThat(streamPersonRepository.convertToListOfNames(allPeople), is(equalTo(peopleNames)));
    }
}

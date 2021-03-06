package pl.jug.torun.jdk8.chapter2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FunctionJava8StyleTest {

    private List<String> inputNamesList = Arrays.asList("Duke", "James", "Kent", "Ward", "Robert", "Martin");

    @Test
    public void shouldTransformListOfNamesToListOfNamesLengths() {
        List<Integer> listOfLengths = inputNamesList.stream()
                .map(String::length)
                .collect(Collectors.toList());

        assertThat(listOfLengths, is(equalTo(Arrays.asList(4, 5, 4, 4, 6, 6))));
    }
}

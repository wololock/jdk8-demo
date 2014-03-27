package pl.jug.torun.jdk8.chapter2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class FunctionJava7StyleTest {

    private List<String> inputNamesList = Arrays.asList("Duke", "James", "Kent", "Ward", "Robert", "Martin");

    @Test
    public void shouldTransformListOfNamesToListOfNamesLengths() {
        List<Integer> listOfLengths = new LinkedList<>();

        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        for (String name : inputNamesList) {
            listOfLengths.add(function.apply(name));
        }

        assertThat(listOfLengths, is(equalTo(Arrays.asList(4,5,4,4,6,6))));
    }
}

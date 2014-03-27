package pl.jug.torun.jdk8.chapter1;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CommandTest {

    @Test
    public void shouldIncreaseBy2AndReturnAsStringPrefixedWithZZZ() {
        //given:
        Command<Integer, String> command = (number -> String.format("ZZZ%d", number + 2));
        //when:
        String expected = command.execute(4);
        //then:
        assertThat(expected, is(equalTo("ZZZ6")));
    }
}

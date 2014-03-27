package pl.jug.torun.jdk8.chapter1;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FooTest {

    private static final String EXPECTED_DEFAULT_METHOD_RESULT = "Foo's random number is: 4";
    private Foo foo = new Foo();

    @Test
    public void shouldCallInterfaceDefultMethod() {
        assertThat(foo.renderNotificationMessage(), is(equalTo(EXPECTED_DEFAULT_METHOD_RESULT)));
    }
}

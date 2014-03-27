package pl.jug.torun.jdk8.chapter1;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class InterfaceWithStaticMethodTest {

    private static final String EXPECTED_RETURN_VALUE = "Works for 4";
    private static final int GIVEN_IT_WORKS_METHOD_ARGUMENT = 4;

    @Test
    public void shouldCallStaticMethodOnInterface() {
        assertThat(InterfaceWithStaticMethod.itWorks(GIVEN_IT_WORKS_METHOD_ARGUMENT), is(equalTo(EXPECTED_RETURN_VALUE)));
    }

    @Test
    public void containsNonInheritedStaticMethod() {
        assertThat(
                Arrays.asList(Foo.class.getMethods()).stream()
                        .map(Method::getName)
                        .anyMatch(name -> name.equals("nonInheritedStaticMethod")), is(equalTo(true))
        );
    }

    @Test
    public void doesNotContainInheritedStaticMethod() {
        assertThat(
                Arrays.asList(Foo.class.getMethods()).stream()
                        .map(Method::getName)
                        .noneMatch(name -> name.equals("itWorks")), is(equalTo(true))
        );
    }
}

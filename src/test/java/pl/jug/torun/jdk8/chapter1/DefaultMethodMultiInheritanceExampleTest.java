package pl.jug.torun.jdk8.chapter1;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DefaultMethodMultiInheritanceExampleTest {

    public interface A {
        default int foo(Integer n) {
            return n + n;
        }
    }

    public interface B {
        default int foo(Integer n) {
            return n + 2;
        }
    }

    public class C implements A, B {
        @Override
        public int foo(Integer n) {
            return A.super.foo(n);
        }
    }

    @Test
    public void shouldReturnTheSameValueAsInterfaceA() {
        //given:
        A a = new A() { };
        C c = new C();
        //when:
        assertThat(c.foo(10), is(equalTo(a.foo(10))));
    }
}

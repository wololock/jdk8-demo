package pl.jug.torun.jdk8.chapter1;

@FunctionalInterface
public interface Command<T, V> {
    V execute(T parameter);

    default void itMayContainsDefaultMethod() {
        //...rocket science
    }

    default Long andAnotherDefaultMethodAndStillBeAFunctionalInterface() {
        return 20L;
    }
}

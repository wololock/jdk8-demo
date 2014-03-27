package pl.jug.torun.jdk8.chapter1;

public class Foo implements InterfaceWithStaticMethod, InterfaceWithDefaultMethod {

    public static void nonInheritedStaticMethod() {
        System.out.println("There is nothing to do here...");
    }

    @Override
    public Integer getRandomNumber() {
        return 4;
    }
}

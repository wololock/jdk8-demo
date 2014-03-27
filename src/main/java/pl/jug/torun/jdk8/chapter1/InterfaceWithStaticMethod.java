package pl.jug.torun.jdk8.chapter1;

public interface InterfaceWithStaticMethod {

    public static String itWorks(int number) {
        return String.format("Works for %d", number);
    }
}

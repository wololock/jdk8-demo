package pl.jug.torun.jdk8.chapter1;

public interface InterfaceWithDefaultMethod {
    Integer getRandomNumber();

    default String renderNotificationMessage() {
        return String.format("%s's random number is: %d", getClass().getSimpleName(), getRandomNumber());
    }
}

package pl.jug.torun.jdk8.chapter3;

import java.time.LocalDate;

public class Person {
    private String name;

    private LocalDate birthDate;

    public static Person create(String name, LocalDate birthDate) {
        return new Person(name, birthDate);
    }

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return name;
    }
}

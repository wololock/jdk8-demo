package pl.jug.torun.jdk8.example.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
}

package com.javarush.repository;

import java.util.List;
import java.util.Optional;

public interface Repo<T> {

    List<T> getAll();

    Optional<T> findById(long id);

    T save(T player);

    T update(T player);

    void delete(T player);

}

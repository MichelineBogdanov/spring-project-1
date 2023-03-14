package com.javarush.repository;

import com.javarush.entity.Task;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository implements Repo<Task> {

//    private final SessionFactory sessionFactory;
//
//    public TaskRepository(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Optional<Task> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Task save(Task player) {
        return null;
    }

    @Override
    public Task update(Task player) {
        return null;
    }

    @Override
    public void delete(Task player) {

    }
}

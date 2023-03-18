package com.javarush.repository;

import com.javarush.entity.Task;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface TaskDao extends Repository<Task, Integer> {

    List<Task> findAll();

    Optional<Task> findById(Integer id);

    Task save(Task task);

    //Task update(Task task);

    void delete(Task task);

}

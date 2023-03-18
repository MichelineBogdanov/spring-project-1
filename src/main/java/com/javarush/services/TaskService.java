package com.javarush.services;

import com.javarush.entity.Task;
import com.javarush.repository.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskDao taskDao;

    public TaskService(@Autowired TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Transactional
    public List<Task> getAll() {
        return taskDao.findAll();
    }

    public Optional<Task> findById(Integer id) {
        return taskDao.findById(id);
    }

    public Task save(Task task) {
        return taskDao.save(task);
    }

    /*public Task update(Task task) {
        return taskDao.update(task);
    }*/

    public void delete(Task task) {
        taskDao.delete(task);
    }

}

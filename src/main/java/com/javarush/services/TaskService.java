package com.javarush.services;

import com.javarush.entity.Task;
import com.javarush.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    public Optional<Task> findById(long id) {
        return taskRepository.findById(id);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        return taskRepository.update(task);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }

}

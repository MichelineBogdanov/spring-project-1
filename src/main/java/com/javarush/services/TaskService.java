package com.javarush.services;

import com.javarush.entity.Task;
import com.javarush.repository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TaskService {

    private final Dao dao;

    public TaskService(@Autowired Dao dao) {
        this.dao = dao;
    }

    public List<Task> getAll() {
        return dao.findAll();
    }

    public List<Task> getAllByPage(int page, int size) {
        Sort.TypedSort<Integer> orders = Sort.sort(Task.class).by(Task::getId);
        Pageable pageRequest = PageRequest.of(page - 1, size, orders);
        Page<Task> all = dao.findAll(pageRequest);
        return all.getContent();
    }

    public Optional<Task> findById(Integer id) {
        return dao.findById(id);
    }

    @Transactional
    public void save(Task task) {
        dao.save(task);
    }

    @Transactional
    public void delete(Task task) {
        dao.delete(task);
    }

    public long countPages() {
        return dao.count();
    }

}

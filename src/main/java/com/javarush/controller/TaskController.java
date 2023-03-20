package com.javarush.controller;

import com.javarush.entity.Status;
import com.javarush.entity.Task;
import com.javarush.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    private final TaskService taskService;

    private int page;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/")
    public ModelAndView allTasks(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        ModelAndView modelAndView = new ModelAndView();
        this.page = page;
        long tasksCount = taskService.countPages();
        long pagesCount = (tasksCount + size - 1) / size;
        List<Task> all = taskService.getAllByPage(page, size);
        modelAndView.setViewName("tasks");
        modelAndView.addObject("page", page);
        modelAndView.addObject("all", all);
        modelAndView.addObject("tasksCount", tasksCount);
        modelAndView.addObject("pagesCount", pagesCount);
        return modelAndView;
    }

    @GetMapping(value = "/edit")
    public ModelAndView editTask() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editpage");
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView updateTask(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        List<String> statuses = Arrays.stream(Status.values()).map(Enum::name).toList();
        Optional<Task> task = taskService.findById(id);
        modelAndView.addObject("task", task.get());
        modelAndView.addObject("statuses", statuses);
        modelAndView.setViewName("editpage");
        return modelAndView;
    }

    @PostMapping(value = "/edit/{id}")
    public ModelAndView updateTask(@ModelAttribute("film") Task task) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(task);
        taskService.save(task);
        modelAndView.setViewName("redirect:/?page=" + this.page);
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView addTask() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addpage");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addTask(@ModelAttribute("film") Task task) {
        ModelAndView modelAndView = new ModelAndView();
        taskService.save(task);
        modelAndView.setViewName("redirect:/?page=" + this.page);
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Task> task = taskService.findById(id);
        taskService.delete(task.get());
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}

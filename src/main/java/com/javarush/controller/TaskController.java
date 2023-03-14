package com.javarush.controller;

import com.javarush.entity.Task;
import com.javarush.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/")
    public ModelAndView allTasks() {
        ModelAndView modelAndView = new ModelAndView();
        List<Task> all = taskService.getAll();
        modelAndView.setViewName("tasks");
        modelAndView.addObject("all", all);
        return modelAndView;
    }

    @GetMapping(value = "/edit")
    public ModelAndView editTask() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        return modelAndView;
    }

}

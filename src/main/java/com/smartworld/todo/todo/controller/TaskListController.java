package com.smartworld.todo.todo.controller;

import com.smartworld.todo.todo.forms.TaskListForm;
import com.smartworld.todo.todo.model.TaskList;
import com.smartworld.todo.todo.service.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskListController {

    private final TaskLisService taskLisService;
    private final Validator validator;

    public TaskListController(TaskLisService taskLisService, Validator validator) {
        this.taskLisService = taskLisService;
        this.validator = validator;
    }

    @GetMapping("/")
    public List<TaskList> getAll() {
        return taskLisService.getTaskList();
    }

    @PostMapping("/")
    public List<TaskList> addNewListTask(@Valid @RequestBody TaskListForm taskListForm, BindingResult bindingResult) {
        validator.validationName(bindingResult);
        taskLisService.addNewListTask(taskListForm);
        return getAll();
    }

    @PutMapping("/{id}")
    public List<TaskList> editListTask(@PathVariable Long id, @Valid @RequestBody TaskListForm taskListForm, BindingResult bindingResult) {
        validator.validationName(bindingResult);
        taskLisService.editListTask(id, taskListForm);
        return getAll();
    }

    @DeleteMapping("/{id}")
    public List<TaskList> deleteListTask(@PathVariable Long id) {
        taskLisService.deleteListTask(id);
        return getAll();
    }
}

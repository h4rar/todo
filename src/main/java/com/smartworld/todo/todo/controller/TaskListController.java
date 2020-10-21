package com.smartworld.todo.todo.controller;

import com.smartworld.todo.todo.forms.TaskListForm;
import com.smartworld.todo.todo.model.TaskList;
import com.smartworld.todo.todo.service.*;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TaskListController {

    private final TaskLisService taskLisService;
    private final Validator validator;

    public TaskListController(TaskLisService taskLisService, Validator validator) {
        this.taskLisService = taskLisService;
        this.validator = validator;
    }

    @GetMapping("/")
    public Page<TaskList> getAll(@PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return taskLisService.getTaskList(pageable);
    }

    @PostMapping("/")
    public Page<TaskList> addNewListTask(@Valid @RequestBody TaskListForm taskListForm, BindingResult bindingResult,
            @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable) {
        validator.validationName(bindingResult);
        taskLisService.addNewListTask(taskListForm);
        return getAll(pageable);
    }

    @PutMapping("/{id}")
    public Page<TaskList> editListTask(@PathVariable Long id,
            @Valid @RequestBody TaskListForm taskListForm, BindingResult bindingResult,
            @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable) {
        validator.validationName(bindingResult);
        taskLisService.editListTask(id, taskListForm);
        return getAll(pageable);
    }

    @DeleteMapping("/{id}")
    public Page<TaskList> deleteListTask(@PathVariable Long id,
            @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable) {
        taskLisService.deleteListTask(id);
        return getAll(pageable);
    }
}

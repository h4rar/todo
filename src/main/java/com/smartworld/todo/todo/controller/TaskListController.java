package com.smartworld.todo.todo.controller;

import com.querydsl.core.types.Predicate;
import com.smartworld.todo.todo.forms.TaskListForm;
import com.smartworld.todo.todo.model.TaskList;
import com.smartworld.todo.todo.repository.TaskListRepository;
import com.smartworld.todo.todo.service.*;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
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
    public Page<TaskList> getAll(
            @QuerydslPredicate(root = TaskList.class) Predicate predicate,
            @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return taskLisService.getTaskList(predicate, pageable);
    }

    @PostMapping("/")
    public Page<TaskList> addNewListTask(
            @Valid @RequestBody TaskListForm taskListForm, BindingResult bindingResult,
            @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable,
            @QuerydslPredicate(root = TaskList.class) Predicate predicate
    ) {
        validator.validationName(bindingResult);
        taskLisService.addNewListTask(taskListForm);
        return getAll(predicate, pageable);
    }

    @PutMapping("/{id}")
    public Page<TaskList> editListTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskListForm taskListForm, BindingResult bindingResult,
            @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable,
            @QuerydslPredicate(root = TaskList.class) Predicate predicate
    ) {
        validator.validationName(bindingResult);
        taskLisService.editListTask(id, taskListForm);
        return getAll(predicate, pageable);
    }

    @DeleteMapping("/{id}")
    public Page<TaskList> deleteListTask(
            @PathVariable Long id,
            @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable,
            @QuerydslPredicate(root = TaskList.class) Predicate predicate
    ) {
        taskLisService.deleteListTask(id);
        return getAll(predicate, pageable);
    }
}

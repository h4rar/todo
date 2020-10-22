package com.smartworld.todo.todo.controller;

import com.querydsl.core.types.Predicate;
import com.smartworld.todo.todo.dto.TaskDto;
import com.smartworld.todo.todo.dto.forms.TaskListForm;
import com.smartworld.todo.todo.model.TaskList;
import com.smartworld.todo.todo.service.*;
import io.swagger.annotations.*;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for TaskList
 */
@RestController
public class TaskListController {

    private final TaskLisService taskLisService;

    private final Validator validator;

    /**
     * @param taskLisService taskLisService
     * @param validator      validator
     */
    public TaskListController(TaskLisService taskLisService, Validator validator) {
        this.taskLisService = taskLisService;
        this.validator = validator;
    }

    /**
     * Get all TaskList
     *
     * @param predicate predicate
     * @param pageable  pageable
     * @return Page<TaskList>
     */
    @GetMapping("/")
    @ApiOperation(value = "Get task list", response = TaskList.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found"),
    })
    public Page<TaskList> getAll(
            @QuerydslPredicate(root = TaskList.class) Predicate predicate,
            @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return taskLisService.getTaskList(predicate, pageable);
    }

    /**
     * Controller
     *
     * @param taskListForm  taskListForm request
     * @param bindingResult bindingResult
     * @param pageable      pageable
     * @param predicate     predicate
     * @return Page<TaskList>
     */
    @PostMapping("/")
    @ApiOperation(value = "Add new task list", response = TaskList.class)
    @ApiResponses({
            @ApiResponse(code = 400, message = "Name empty"),
            @ApiResponse(code = 404, message = "Task is not found")
    })
    public Page<TaskList> addNewListTask(
            @Valid @RequestBody TaskListForm taskListForm, BindingResult bindingResult,
            @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable,
            @QuerydslPredicate(root = TaskList.class) Predicate predicate
    ) {
        validator.validationName(bindingResult);
        taskLisService.addNewListTask(taskListForm);
        return getAll(predicate, pageable);
    }

    /**
     * Controller
     *
     * @param id            TaskList id
     * @param taskListForm  taskListForm request
     * @param bindingResult bindingResult
     * @param pageable      pageable
     * @param predicate     predicate
     * @return Page<TaskList>
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "Edit task list", response = TaskList.class)
    @ApiResponses({
            @ApiResponse(code = 400, message = "Name empty"),
            @ApiResponse(code = 404, message = "Task is not found")
    })
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

    /**
     * Controller
     *
     * @param id        TaskList id
     * @param pageable  pageable
     * @param predicate predicate
     * @return Page<TaskList>
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete task list", response = TaskList.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found")
    })
    public Page<TaskList> deleteListTask(
            @PathVariable Long id,
            @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable,
            @QuerydslPredicate(root = TaskList.class) Predicate predicate
    ) {
        taskLisService.deleteListTask(id);
        return getAll(predicate, pageable);
    }
}

package com.smartworld.todo.todo.controller;

import com.smartworld.todo.todo.dto.TaskDto;
import com.smartworld.todo.todo.dto.forms.*;
import com.smartworld.todo.todo.service.interfaces.*;
import io.swagger.annotations.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Controller for Task
 */
@RestController
@Api(value = "TaskController")
public class TaskController {

    private final TaskService taskService;

    private final Validator validator;

    /**
     * @param taskService taskService
     * @param validator   validator
     */
    public TaskController(TaskService taskService, Validator validator) {
        this.taskService = taskService;
        this.validator = validator;
    }


    /**
     * @param id TaskList id
     * @return Page<TaskList>
     */
    @GetMapping("/list/{id}")
    @ApiOperation(value = "Get tasks", response = TaskDto.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found")
    })
    public List<TaskDto> getTasks(@PathVariable UUID id) {
        return taskService.getTasks(id);
    }

    /**
     * @param id            TaskList id
     * @param taskForm      taskForm request
     * @param bindingResult bindingResult
     * @return Page<TaskList>
     */
    @PostMapping("/list/{id}")
    @ApiOperation(value = "Add new task", response = TaskDto.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found"),
            @ApiResponse(code = 400, message = "Name empty")
    })
    public List<TaskDto> addNewTask(@PathVariable UUID id, @Valid @RequestBody TaskForm taskForm, BindingResult bindingResult) {
        validator.validationName(bindingResult);
        taskService.addNewTask(id, taskForm);
        return getTasks(id);
    }

    /**
     * @param id               TaskList id
     * @param taskId           taskId
     * @param taskFormMarkDone taskFormMarkDone request
     * @param bindingResult    bindingResult
     * @return Page<TaskList>
     */
    @PostMapping("/list/{id}/mark-done/{taskId}")
    @ApiOperation(value = "mark Done task", response = TaskDto.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found"),
            @ApiResponse(code = 400, message = "Ready can not be empty!")
    })
    public List<TaskDto> markDoneTask(
            @PathVariable UUID id, @PathVariable UUID taskId, @Valid @RequestBody TaskFormMarkDone taskFormMarkDone, BindingResult bindingResult
    ) {
        validator.validationMarkDone(bindingResult);
        taskService.markDoneTask(taskId, taskFormMarkDone);
        return getTasks(id);
    }

    /**
     * @param id            TaskList id
     * @param taskId        taskId
     * @param taskFormPut   taskFormPut
     * @param bindingResult bindingResult
     * @return Page<TaskList>
     */
    @PutMapping("/list/{id}/task/{taskId}")
    @ApiOperation(value = "Edit task", response = TaskDto.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found"),
            @ApiResponse(code = 400, message = "Name empty")
    })
    public List<TaskDto> editTask(@PathVariable UUID id, @PathVariable UUID taskId, @Valid @RequestBody TaskFormPut taskFormPut, BindingResult bindingResult) {
        validator.validationName(bindingResult);
        taskService.editTask(taskId, taskFormPut);
        return getTasks(id);
    }

    /**
     * @param id     TaskList id
     * @param taskId taskId
     * @return List<TaskDto>
     */
    @DeleteMapping("/list/{id}/task/{taskId}")
    @ApiOperation(value = "Delete task", response = TaskDto.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found")
    })
    public List<TaskDto> deleteTask(@PathVariable UUID id, @PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return getTasks(id);
    }
}

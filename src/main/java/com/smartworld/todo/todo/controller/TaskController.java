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
@Api(tags = {"Задачи"})
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
    @ApiOperation(value = "Получить все задачи из списка дел")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found")
    })
    public List<TaskDto> getTasks(
            @ApiParam(value = "Необходимо передать id списка дел\n Пример: http://localhost:8080/list/fcff5c91-3163-4a15-af7d-014a8834db11", required = true)
            @PathVariable UUID id
    ) {
        return taskService.getTasks(id);
    }

    /**
     * @param id            TaskList id
     * @param taskForm      taskForm request
     * @param bindingResult bindingResult
     * @return Page<TaskList>
     */
    @PostMapping("/list/{id}")
    @ApiOperation(value = "Добавить задачу к списку дел")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found"),
            @ApiResponse(code = 400, message = "Name empty")
    })
    public List<TaskDto> addNewTask(
            @ApiParam(value = "Необходимо передать id списка дел", required = true)
            @PathVariable UUID id,
            @ApiParam(value = "Необходимо заполнить имя, важность и описание создаваемого списка дел", required = true)
            @Valid @RequestBody TaskForm taskForm, BindingResult bindingResult
    ) {
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
    @ApiOperation(value = "Отметить задачу как решенную/нерешенную")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found"),
            @ApiResponse(code = 400, message = "Ready can not be empty!")
    })
    public List<TaskDto> markDoneTask(
            @ApiParam(value = "Необходимо передать id списка дел", required = true)
            @PathVariable UUID id,
            @ApiParam(value = "Необходимо передать id задачи", required = true)
            @PathVariable UUID taskId,
            @ApiParam(value = "Необходимо передать статус задачи", required = true)
            @Valid @RequestBody TaskFormMarkDone taskFormMarkDone, BindingResult bindingResult
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
    @ApiOperation(value = "Изменить задачу")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found"),
            @ApiResponse(code = 400, message = "Name empty")
    })
    public List<TaskDto> editTask(
            @ApiParam(value = "Необходимо передать id списка дел", required = true)
            @PathVariable UUID id,
            @ApiParam(value = "Необходимо передать id задачи", required = true)
            @PathVariable UUID taskId,
            @ApiParam(value = "Необходимо передать имя, описание, важность и статус задачи", required = true)
            @Valid @RequestBody TaskFormPut taskFormPut, BindingResult bindingResult
    ) {
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
    @ApiOperation(value = "Удалить задачу")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Task is not found")
    })
    public List<TaskDto> deleteTask(
            @ApiParam(value = "Необходимо передать id списка дел", required = true)
            @PathVariable UUID id,
            @ApiParam(value = "Необходимо передать id задачи", required = true)
            @PathVariable UUID taskId
    ) {
        taskService.deleteTask(taskId);
        return getTasks(id);
    }
}

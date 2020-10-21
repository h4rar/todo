package com.smartworld.todo.todo.controller;

import com.smartworld.todo.todo.dto.TaskDto;
import com.smartworld.todo.todo.forms.*;
import com.smartworld.todo.todo.repository.TaskListRepository;
import com.smartworld.todo.todo.service.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;
    private final Validator validator;

    public TaskController(TaskService taskService, Validator validator) {
        this.taskService = taskService;
        this.validator = validator;
    }

    @GetMapping("/{id}")
    public List<TaskDto> getTasks(@PathVariable Long id){
        return taskService.getTasks(id);
    }

    @PostMapping("/{id}")
    public List<TaskDto> addNewTask(@PathVariable Long id, @Valid @RequestBody TaskForm taskForm, BindingResult bindingResult){
        validator.validationName(bindingResult);
        taskService.addNewTask(id, taskForm);
        return getTasks(id);
    }

    @PostMapping("/{id}/mark-done/{taskId}")
    public List<TaskDto> markDoneTask(@PathVariable Long id, @PathVariable Long taskId, @Valid @RequestBody TaskFormMarkDone taskFormMarkDone, BindingResult bindingResult){
        validator.validationMarkDone(bindingResult);
        taskService.markDoneTask(taskId, taskFormMarkDone);
        return getTasks(id);
    }

    @PutMapping("/{id}/task/{taskId}")
    public List<TaskDto> editTask(@PathVariable Long id, @PathVariable Long taskId, @Valid @RequestBody TaskFormPut taskFormPut, BindingResult bindingResult) {
        validator.validationName(bindingResult);
        taskService.editTask(taskId, taskFormPut);
        return getTasks(id);
    }

    @DeleteMapping("/{id}/task/{taskId}")
    public List<TaskDto> deleteTask(@PathVariable Long id, @PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return getTasks(id);
    }
}

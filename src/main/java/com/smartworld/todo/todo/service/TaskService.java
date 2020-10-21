package com.smartworld.todo.todo.service;

import com.smartworld.todo.todo.dto.TaskDto;
import com.smartworld.todo.todo.forms.*;

import java.util.List;

public interface TaskService {
    List<TaskDto> getTasks(Long id);
    void addNewTask(Long id, TaskForm taskForm);
    void editTask(Long taskId, TaskFormPut taskFormPut);
    void deleteTask(Long taskId);
    void markDoneTask(Long taskId, TaskFormMarkDone taskFormMarkDone);
}

package com.smartworld.todo.todo.service;

import com.smartworld.todo.todo.dto.TaskDto;
import com.smartworld.todo.todo.dto.forms.*;

import java.util.List;

/**
 * Service for tasks
 */
public interface TaskService {

    /**
     * @param id task id
     * @return List<TaskDto>
     */
    List<TaskDto> getTasks(Long id);

    /**
     * @param id       task id
     * @param taskForm taskForm
     */
    void addNewTask(Long id, TaskForm taskForm);

    /**
     * @param taskId      task id
     * @param taskFormPut taskFormPut request
     */
    void editTask(Long taskId, TaskFormPut taskFormPut);

    /**
     * @param taskId task id
     */
    void deleteTask(Long taskId);

    /**
     * @param taskId           task id
     * @param taskFormMarkDone taskFormMarkDone request
     */
    void markDoneTask(Long taskId, TaskFormMarkDone taskFormMarkDone);
}

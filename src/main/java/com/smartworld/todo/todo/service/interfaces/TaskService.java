package com.smartworld.todo.todo.service.interfaces;

import com.smartworld.todo.todo.dto.TaskDto;
import com.smartworld.todo.todo.dto.forms.*;

import java.util.*;

/**
 * Service for tasks
 */
public interface TaskService {

    /**
     * @param id task id
     * @return List<TaskDto>
     */
    List<TaskDto> getTasks(UUID id);

    /**
     * @param id       task id
     * @param taskForm taskForm
     */
    void addNewTask(UUID id, TaskForm taskForm);

    /**
     * @param taskId      task id
     * @param taskFormPut taskFormPut request
     */
    void editTask(UUID taskId, TaskFormPut taskFormPut);

    /**
     * @param taskId task id
     */
    void deleteTask(UUID taskId);

    /**
     * @param taskId           task id
     * @param taskFormMarkDone taskFormMarkDone request
     */
    void markDoneTask(UUID taskId, TaskFormMarkDone taskFormMarkDone);
}

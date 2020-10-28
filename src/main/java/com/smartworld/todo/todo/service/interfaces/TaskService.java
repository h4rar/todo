package com.smartworld.todo.todo.service.interfaces;

import com.smartworld.todo.todo.dto.TaskDto;
import com.smartworld.todo.todo.dto.forms.*;

import java.util.*;

/**
 * Сервис для задач
 */
public interface TaskService {

    /**
     * Возвращает список задач
     *
     * @param id id списка дел
     * @return список задач
     */
    List<TaskDto> getTasks(UUID id);

    /**
     * Добавляет новую задачу к списку дел
     *
     * @param id       id списка дел
     * @param taskForm данные для новой задачи
     */
    void addNewTask(UUID id, TaskForm taskForm);

    /**
     * Изменяет задачу
     *
     * @param taskId      id задачи
     * @param taskFormPut данные для изменения задачи
     */
    void editTask(UUID taskId, TaskFormPut taskFormPut);

    /**
     * Удаляет задачу из списка дел
     *
     * @param taskId id задачи
     */
    void deleteTask(UUID taskId);

    /**
     * Отмечает задачу как решенную/нерешенную
     *
     * @param taskId           id задачи
     * @param taskFormMarkDone данные для изменения статуса задачи
     */
    void markDoneTask(UUID taskId, TaskFormMarkDone taskFormMarkDone);
}

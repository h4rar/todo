package com.smartworld.todo.todo.service.interfaces;

import com.querydsl.core.types.Predicate;
import com.smartworld.todo.todo.dto.forms.TaskListForm;
import com.smartworld.todo.todo.model.TaskList;
import org.springframework.data.domain.*;

import java.util.UUID;

/**
 * Сервис для списка дел
 */
public interface TaskListService {

    /**
     * Возвращает списки дел
     *
     * @param predicate Предикаты. Обеспечивают фильтрацию
     * @param pageable  Пагинация. Обеспечивает пагиначию и сортировку
     * @return списки дел
     */
    Page<TaskList> getTaskList(Predicate predicate, Pageable pageable);

    /**
     * Добавляет новый список дел
     *
     * @param taskListForm данные для добавления списка дел
     */
    void addNewListTask(TaskListForm taskListForm);

    /**
     * Изменяет список дел
     *
     * @param id           id списка дел
     * @param taskListForm данные для изменения списка дел
     */
    void editListTask(UUID id, TaskListForm taskListForm);

    /**
     * Удалить список дел
     *
     * @param id id списка дел
     */
    void deleteListTask(UUID id);
}

package com.smartworld.todo.todo.service.interfaces;

import com.querydsl.core.types.Predicate;
import com.smartworld.todo.todo.dto.forms.TaskListForm;
import com.smartworld.todo.todo.model.TaskList;
import org.springframework.data.domain.*;

import java.util.UUID;

/**
 * Service for task lists
 */
public interface TaskLisService {

    /**
     * @param predicate predicate
     * @param pageable  pageable
     * @return Page<TaskList>
     */
    Page<TaskList> getTaskList(Predicate predicate, Pageable pageable);

    /**
     * @param taskListForm taskListForm request
     */
    void addNewListTask(TaskListForm taskListForm);

    /**
     * @param id           task list id
     * @param taskListForm taskListForm request
     */
    void editListTask(UUID id, TaskListForm taskListForm);

    /**
     * @param id task list id
     */
    void deleteListTask(UUID id);
}

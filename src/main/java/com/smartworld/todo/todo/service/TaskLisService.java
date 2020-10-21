package com.smartworld.todo.todo.service;

import com.querydsl.core.types.Predicate;
import com.smartworld.todo.todo.forms.TaskListForm;
import com.smartworld.todo.todo.model.TaskList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.*;

public interface TaskLisService {
    Page<TaskList> getTaskList(Predicate predicate, Pageable pageable);
    void addNewListTask(TaskListForm taskListForm);
    void editListTask(Long id, TaskListForm taskListForm);
    void deleteListTask(Long id);
}

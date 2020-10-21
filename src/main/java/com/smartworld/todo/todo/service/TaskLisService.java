package com.smartworld.todo.todo.service;

import com.smartworld.todo.todo.exception.IncorrectNameException;
import com.smartworld.todo.todo.forms.TaskListForm;
import com.smartworld.todo.todo.model.TaskList;

import java.util.List;

public interface TaskLisService {
    List<TaskList> getTaskList();
    void addNewListTask(TaskListForm taskListForm);
    void editListTask(Long id, TaskListForm taskListForm);
    void deleteListTask(Long id);
}

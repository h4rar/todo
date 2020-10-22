package com.smartworld.todo.todo.service;

import com.querydsl.core.types.Predicate;
import com.smartworld.todo.todo.dto.forms.TaskListForm;
import com.smartworld.todo.todo.exception.NotFoundException;
import com.smartworld.todo.todo.model.TaskList;
import com.smartworld.todo.todo.repository.TaskListRepository;
import com.smartworld.todo.todo.service.interfaces.TaskLisService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Implementation TaskLisService
 */
@Component
public class TaskLisServiceImpl implements TaskLisService {

    private final TaskListRepository taskListRepository;

    public TaskLisServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public Page<TaskList> getTaskList(Predicate predicate, Pageable pageable) {
        return taskListRepository.findAll(predicate, pageable);
    }

    @Override
    public void addNewListTask(TaskListForm taskListForm) {
        Date dateCreate = new Date();
        TaskList taskList = TaskList.builder()
                .dateOfCreation(dateCreate)
                .name(taskListForm.getName())
                .taskSet(new ArrayList<>())
                .build();
        taskListRepository.save(taskList);
    }

    @Override
    public void editListTask(UUID id, TaskListForm taskListForm) {
        Date date = new Date();
        TaskList taskList = taskListRepository.findById(id).orElseThrow(NotFoundException::new);
        taskList.setName(taskListForm.getName());
        taskList.setDateOfChange(date);
        taskListRepository.save(taskList);
    }

    @Override
    public void deleteListTask(UUID id) {
        TaskList taskList = taskListRepository.findById(id).orElseThrow(NotFoundException::new);
        taskListRepository.delete(taskList);
    }
}

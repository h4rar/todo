package com.smartworld.todo.todo.service;

import com.querydsl.core.types.Predicate;
import com.smartworld.todo.todo.dto.forms.TaskListForm;
import com.smartworld.todo.todo.exception.NotFoundException;
import com.smartworld.todo.todo.model.TaskList;
import com.smartworld.todo.todo.repository.TaskListRepository;
import com.smartworld.todo.todo.service.interfaces.TaskListService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

/**
 * Имплементация TaskListService
 */
@Component
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    /**
     * Конструктор
     *
     * @param taskListRepository репозиторий списков дел
     */
    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public Page<TaskList> getTaskList(Predicate predicate, Pageable pageable) {
        if (taskListRepository.findAll(predicate, pageable).isEmpty()) {
            throw new NotFoundException();
        }
        return taskListRepository.findAll(predicate, pageable);
    }

    @Override
    public void addNewListTask(TaskListForm taskListForm) {
        TaskList taskList = TaskList.builder()
                .dateOfCreation(LocalDate.now())
                .name(taskListForm.getName())
                .taskSet(new ArrayList<>())
                .build();
        taskListRepository.save(taskList);
    }

    @Override
    public void editListTask(UUID id, TaskListForm taskListForm) {
        TaskList taskList = taskListRepository.findById(id).orElseThrow(NotFoundException::new);
        taskList.setName(taskListForm.getName());
        taskList.setDateOfChange(LocalDate.now());
        taskListRepository.save(taskList);
    }

    @Override
    public void deleteListTask(UUID id) {
        TaskList taskList = taskListRepository.findById(id).orElseThrow(NotFoundException::new);
        taskListRepository.delete(taskList);
    }
}

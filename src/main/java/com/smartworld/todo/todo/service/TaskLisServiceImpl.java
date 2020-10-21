package com.smartworld.todo.todo.service;

import com.smartworld.todo.todo.exception.*;
import com.smartworld.todo.todo.forms.TaskListForm;
import com.smartworld.todo.todo.model.TaskList;
import com.smartworld.todo.todo.repository.TaskListRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import org.springframework.data.domain.*;
import java.util.*;

@Component
public class TaskLisServiceImpl implements TaskLisService {

    private final TaskListRepository taskListRepository;

    public TaskLisServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public Page<TaskList> getTaskList(Pageable pageable) {
        return taskListRepository.findAll(pageable);
    }

    @Override
    public void addNewListTask(TaskListForm taskListForm){
        Date dateCreate = new Date();
        TaskList taskList = TaskList.builder()
                .dateOfCreation(dateCreate)
                .name(taskListForm.getName())
                .taskSet(new ArrayList<>())
                .build();
        taskListRepository.save(taskList);
    }

    @Override
    public void editListTask(Long id, TaskListForm taskListForm) {
        Date date = new Date();
        TaskList taskList = taskListRepository.findById(id).orElseThrow(NotFoundException::new);
        taskList.setName(taskListForm.getName());
        taskList.setDateOfChange(date);
        taskListRepository.save(taskList);
    }

    @Override
    public void deleteListTask(Long id) {
        TaskList taskList = taskListRepository.findById(id).orElseThrow(NotFoundException::new);
        taskListRepository.delete(taskList);
    }
}

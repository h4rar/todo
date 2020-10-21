package com.smartworld.todo.todo.service;

import com.smartworld.todo.todo.dto.TaskDto;
import com.smartworld.todo.todo.exception.NotFoundException;
import com.smartworld.todo.todo.forms.*;
import com.smartworld.todo.todo.model.*;
import com.smartworld.todo.todo.repository.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TaskServiceImpl implements TaskService {

    private final TaskListRepository taskListRepository;

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskListRepository taskListRepository, TaskRepository taskRepository) {
        this.taskListRepository = taskListRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskDto> getTasks(Long id) {
        List<TaskDto> taskDtoList = new ArrayList<>();
        TaskList taskList = taskListRepository.findById(id).orElseThrow(NotFoundException::new);
        List<Task> taskSet = taskList.getTaskSet();
        for (Task task : taskSet) {
            TaskDto taskDto = TaskDto.builder()
                    .name(task.getName())
                    .description(task.getDescription())
                    .importance(task.getImportance())
                    .ready(task.isReady())
                    .build();
            taskDtoList.add(taskDto);
        }
        return taskDtoList;
    }

    @Override
    public void addNewTask(Long id, TaskForm taskForm) {
        Date dateCreate = new Date();
        TaskList taskList = taskListRepository.findById(id).orElseThrow(NotFoundException::new);
        Task task = Task.builder()
                .dateOfCreation(dateCreate)
                .name(taskForm.getName())
                .description(taskForm.getDescription())
                .importance(taskForm.getImportance())
                .taskList(taskList)
                .build();
        taskRepository.save(task);
    }

    @Override
    public void editTask(Long taskId, TaskFormPut taskFormPut) {
        Task task = taskRepository.findById(taskId).orElseThrow(NotFoundException::new);
        Date dateChange = new Date();
        task.setName(taskFormPut.getName());
        task.setDateOfChange(dateChange);
        String description = taskFormPut.getDescription();
        int importance = taskFormPut.getImportance();
        boolean isReady = taskFormPut.isReady();
        task.setDescription(description);
        task.setImportance(importance);
        task.setReady(isReady);
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(NotFoundException::new);
        taskRepository.delete(task);
    }

    @Override
    public void markDoneTask(Long taskId, TaskFormMarkDone taskFormMarkDone) {
        Task task = taskRepository.findById(taskId).orElseThrow(NotFoundException::new);
        task.setReady(taskFormMarkDone.isReady());
        taskRepository.save(task);
    }
}

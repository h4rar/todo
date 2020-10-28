package com.smartworld.todo.todo.service;

import com.smartworld.todo.todo.dto.TaskDto;
import com.smartworld.todo.todo.dto.forms.*;
import com.smartworld.todo.todo.exception.NotFoundException;
import com.smartworld.todo.todo.model.*;
import com.smartworld.todo.todo.repository.*;
import com.smartworld.todo.todo.service.interfaces.TaskService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

/**
 * Имплементация TaskService
 */
@Component
public class TaskServiceImpl implements TaskService {

    private final TaskListRepository taskListRepository;

    private final TaskRepository taskRepository;

    /**
     * Констркуктор
     *
     * @param taskListRepository репозиторий списков дел
     * @param taskRepository     репозиторий задач
     */
    public TaskServiceImpl(TaskListRepository taskListRepository, TaskRepository taskRepository) {
        this.taskListRepository = taskListRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskDto> getTasks(UUID id) {
        List<TaskDto> taskDtoList = new ArrayList<>();
        TaskList taskList = taskListRepository.findById(id).orElseThrow(NotFoundException::new);
        List<Task> taskSet = taskList.getTaskSet();
        for (Task task : taskSet) {
            TaskDto taskDto = TaskDto.builder()
                    .id(id)
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
    public void addNewTask(UUID id, TaskForm taskForm) {
        TaskList taskList = taskListRepository.findById(id).orElseThrow(NotFoundException::new);
        Task task = Task.builder()
                .dateOfCreation(LocalDate.now())
                .name(taskForm.getName())
                .description(taskForm.getDescription())
                .importance(taskForm.getImportance())
                .taskList(taskList)
                .build();
        taskRepository.save(task);
    }

    @Override
    public void editTask(UUID taskId, TaskFormPut taskFormPut) {
        Task task = taskRepository.findById(taskId).orElseThrow(NotFoundException::new);
        task.setName(taskFormPut.getName());
        task.setDateOfChange(LocalDate.now());
        String description = taskFormPut.getDescription();
        int importance = taskFormPut.getImportance();
        boolean isReady = taskFormPut.isReady();
        task.setDescription(description);
        task.setImportance(importance);
        task.setReady(isReady);
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(UUID taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(NotFoundException::new);
        taskRepository.delete(task);
    }

    @Override
    public void markDoneTask(UUID taskId, TaskFormMarkDone taskFormMarkDone) {
        Task task = taskRepository.findById(taskId).orElseThrow(NotFoundException::new);
        task.setReady(taskFormMarkDone.isReady());
        taskRepository.save(task);
    }
}

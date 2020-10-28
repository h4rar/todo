package com.smartworld.todo.todo.controller;

import com.querydsl.core.types.Predicate;
import com.smartworld.todo.todo.dto.forms.TaskListForm;
import com.smartworld.todo.todo.model.TaskList;
import com.smartworld.todo.todo.repository.TaskListRepository;
import com.smartworld.todo.todo.service.interfaces.*;
import com.smartworld.todo.todo.swagger.config.annotation.MyApiPageableAndQuerydsl;
import io.swagger.annotations.*;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Контроллер для списка дел
 */
@Api(tags = {"Список дел"})
@RestController
public class TaskListController {

    private final TaskListService taskListService;

    private final ValidatorService validatorService;

    /**
     * Конструктор
     *
     * @param taskListService сервис списка дел
     * @param validatorService      сервис валидации
     */
    public TaskListController(TaskListService taskListService, ValidatorService validatorService) {
        this.taskListService = taskListService;
        this.validatorService = validatorService;
    }

    /**
     * Возвращает списки дел
     *
     * @param predicate Предикаты. Обеспечивают фильтрацию
     * @param pageable  Пагинация. Обеспечивает пагиначию и сортировку
     * @return списки дел
     */
    @GetMapping("/")
    @ApiOperation(value = "getTaskList() Получить список дел")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Not found"),
    })
    @MyApiPageableAndQuerydsl
    public Page<TaskList> getTaskList(
            @ApiIgnore @QuerydslPredicate(root = TaskList.class, bindings = TaskListRepository.class) Predicate predicate,
            @ApiIgnore @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return taskListService.getTaskList(predicate, pageable);
    }

    /**
     * Добавляет новый список дел
     *
     * @param taskListForm данные для нового списка дел
     * @param predicate    Предикаты. Обеспечивают фильтрацию
     * @param pageable     Пагинация. Обеспечивает пагиначию и сортировку
     * @return списки дел
     */
    @PostMapping("/list")
    @ApiOperation(value = "addNewTaskList() Добавить новый список дел. После успешного добавления вызывается метод getTaskList(), " +
            "поэтому можно передать те же параметры фидьтрации сортировки и т.д")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Name empty"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @MyApiPageableAndQuerydsl
    public Page<TaskList> addNewTaskList(
            @ApiParam(value = "Необходимо заполнить имя создаваемого списка дел", required = true)
            @Valid @RequestBody TaskListForm taskListForm, BindingResult bindingResult,
            @ApiIgnore @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable,
            @ApiIgnore @QuerydslPredicate(root = TaskList.class) Predicate predicate
    ) {
        validatorService.validationName(bindingResult);
        taskListService.addNewListTask(taskListForm);
        return getTaskList(predicate, pageable);
    }

    /**
     * Изменяет выбранный список дел
     *
     * @param id           id списка дел
     * @param taskListForm данные для изменения списка дел
     * @param predicate    Предикаты. Обеспечивают фильтрацию
     * @param pageable     Пагинация. Обеспечивает пагиначию и сортировку
     * @return списки дел
     */
    @PutMapping("/list/{id}")
    @ApiOperation(value = "editListTask() Изменить выбранный список дел. После успешного изменения вызывается метод getTaskList(), " +
            "поэтому можно передать те же параметры фидьтрации сортировки и т.д")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Name empty"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @MyApiPageableAndQuerydsl
    public Page<TaskList> editListTask(
            @ApiParam(value = "Необходимо передать id списка дел\n Пример: http://localhost:8080/list/afd1bed2-cf62-4b03-b9c9-341d2ac6a30c", required = true)
            @PathVariable UUID id,
            @ApiParam(value = "Необходимо заполнить имя изменяемого списка дел", required = true)
            @Valid @RequestBody TaskListForm taskListForm, BindingResult bindingResult,
            @ApiIgnore @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable,
            @ApiIgnore @QuerydslPredicate(root = TaskList.class) Predicate predicate
    ) {
        validatorService.validationName(bindingResult);
        taskListService.editListTask(id, taskListForm);
        return getTaskList(predicate, pageable);
    }

    /**
     * Удаляет список дел
     *
     * @param id        id списка дел
     * @param predicate Предикаты. Обеспечивают фильтрацию
     * @param pageable  Пагинация. Обеспечивает пагиначию и сортировку
     * @return списки дел
     */
    @DeleteMapping("/list/{id}")
    @ApiOperation(value = "deleteTaskList() Удалить выбранный спимок дел. Каскадно удалятся все задачи, принадлежащие этому списку." +
            " После успешного удаления вызывается метод getTaskList(), " +
            "поэтому можно передать те же параметры фидьтрации сортировки и т.д")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Not found")
    })
    @MyApiPageableAndQuerydsl
    public Page<TaskList> deleteTaskList(
            @ApiParam(value = "Необходимо передать id списка дел\n Пример: http://localhost:8080/list/b8648553-087f-4253-8ff5-947bda5a2bd2", required = true)
            @PathVariable UUID id,
            @ApiIgnore @PageableDefault(sort = {"dateOfCreation"}, direction = Sort.Direction.ASC) Pageable pageable,
            @ApiIgnore @QuerydslPredicate(root = TaskList.class) Predicate predicate
    ) {
        taskListService.deleteListTask(id);
        return getTaskList(predicate, pageable);
    }
}

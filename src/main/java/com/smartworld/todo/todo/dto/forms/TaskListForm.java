package com.smartworld.todo.todo.dto.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * DTO для добавления нового списка дел
 */
@Data
public class TaskListForm {

    /**
     * Поле имя
     */
    @NotBlank
    private String name;
}

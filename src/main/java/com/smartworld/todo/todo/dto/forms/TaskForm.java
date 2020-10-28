package com.smartworld.todo.todo.dto.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * DTO для добавления новой задачи
 */
@Data
public class TaskForm {

    /**
     * Поле имя
     */
    @NotBlank
    private String name;

    /**
     * Поле описание
     */
    private String description;

    /**
     * Поле важность
     */
    private int importance;
}

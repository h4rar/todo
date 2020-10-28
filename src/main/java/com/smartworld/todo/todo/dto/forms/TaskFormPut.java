package com.smartworld.todo.todo.dto.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * DTO для изменения задачи
 */
@Data
public class TaskFormPut {

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

    /**
     * статус задачи
     */
    private boolean ready;
}

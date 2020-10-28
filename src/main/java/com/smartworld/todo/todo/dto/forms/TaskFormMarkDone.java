package com.smartworld.todo.todo.dto.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * DTO для изменения статуса задачи
 */
@Data
public class TaskFormMarkDone {

    /**
     * статус здачи
     */
    @NotNull
    private boolean ready;
}

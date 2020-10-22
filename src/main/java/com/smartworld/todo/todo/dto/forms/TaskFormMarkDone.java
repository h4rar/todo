package com.smartworld.todo.todo.dto.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * TaskFormMarkDone request
 */
@Data
public class TaskFormMarkDone {
    @NotNull
    private boolean ready;
}

package com.smartworld.todo.todo.dto.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * TaskFormPut request
 */
@Data
public class TaskFormPut {

    @NotBlank
    private String name;

    private String description;

    private int importance;

    private boolean ready;
}

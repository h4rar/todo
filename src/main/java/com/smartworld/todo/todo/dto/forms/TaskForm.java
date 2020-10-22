package com.smartworld.todo.todo.dto.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * TaskForm request
 */
@Data
public class TaskForm {

    @NotBlank
    private String name;

    private String description;

    private int importance;
}

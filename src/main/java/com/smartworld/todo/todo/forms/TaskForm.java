package com.smartworld.todo.todo.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TaskForm {
    @NotBlank
    private String name;
    private String description;
    private int importance;
}

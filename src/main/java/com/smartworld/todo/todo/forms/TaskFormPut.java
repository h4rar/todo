package com.smartworld.todo.todo.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TaskFormPut {
    @NotBlank
    private String name;
    private String description;
    private int importance;
    private boolean ready;
}

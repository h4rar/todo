package com.smartworld.todo.todo.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TaskListForm {
    @NotBlank
    private String name;
}

package com.smartworld.todo.todo.dto.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * TaskListForm request
 */
@Data
public class TaskListForm {

    @NotBlank
    private String name;
}

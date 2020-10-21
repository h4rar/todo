package com.smartworld.todo.todo.forms;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class TaskFormMarkDone {
    @NotNull
    private boolean ready;
}

package com.smartworld.todo.todo.dto;

import lombok.*;

/**
 * TaskDto response
 */
@Builder
@Data
public class TaskDto {
    private String name;
    private String description;
    private int importance;
    private boolean ready;
}

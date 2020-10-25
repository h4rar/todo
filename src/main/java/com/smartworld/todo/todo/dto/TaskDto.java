package com.smartworld.todo.todo.dto;

import lombok.*;

import java.util.UUID;

/**
 * TaskDto response
 */
@Builder
@Data
public class TaskDto {
    private UUID id;
    private String name;
    private String description;
    private int importance;
    private boolean ready;
}

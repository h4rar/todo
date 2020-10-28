package com.smartworld.todo.todo.dto;

import lombok.*;

import java.util.UUID;

/**
 * DTO ответа на запрос получения задачи
 */
@Builder
@Data
public class TaskDto {
    /**
     * Поле id
     */
    private UUID id;
    /**
     * Поле имя
     */
    private String name;
    /**
     * Поле опичание
     */
    private String description;
    /**
     * Поле важность
     */
    private int importance;
    /**
     * статус задачи
     */
    private boolean ready;
}

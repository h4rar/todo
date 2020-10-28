package com.smartworld.todo.todo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Сущность задачи
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Check(constraints = "importance>=1 AND importance<=5")
public class Task {

    /**
     * Поле id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    /**
     * Дата создания
     */
    @Column(name = "date_of_creation", nullable = false)
    private LocalDate dateOfCreation;

    /**
     * Дата изменения
     */
    @Column(name = "date_of_change")
    private LocalDate dateOfChange;

    /**
     * Поле имя
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Поле описание
     */
    @Column(name = "description")
    private String description;

    /**
     * Поле важности
     */
    @Column(name = "importance")
    private int importance;

    /**
     * Поле статус задачи
     */
    @Column(name = "ready", columnDefinition = "boolean default 'false'", nullable = false)
    private boolean ready;

    /**
     * К какому списку дел принадлежит
     */
    @ManyToOne
    @JoinColumn(name = "task_list_id")
    @JsonBackReference
    private TaskList taskList;
}

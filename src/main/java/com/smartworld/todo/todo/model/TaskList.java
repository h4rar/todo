package com.smartworld.todo.todo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Сущность списка дел
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskList {

    /**
     * Поле id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    /**
     * Поле дата создания
     */
    @Column(name = "date_of_creation", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfCreation;

    /**
     * Поле дата изменения
     */
    @Column(name = "date_of_change")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfChange;

    /**
     * Поле имя
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Список задач
     */
    @OneToMany(mappedBy = "taskList")
    @JsonManagedReference
    @JsonBackReference
    private List<Task> taskSet;
}

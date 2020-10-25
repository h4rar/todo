package com.smartworld.todo.todo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

/**
 * TaskList entity
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "date_of_creation", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfCreation;

    @Column(name = "date_of_change")
    private Date dateOfChange;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "taskList")
    @JsonManagedReference
    @JsonBackReference
    private List<Task> taskSet;
}

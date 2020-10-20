package com.smartworld.todo.todo.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_of_creation", nullable = false)
    private Date dateOfCreation;

    @Column(name = "date_of_change")
    private Date  dateOfChange;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy="taskList", cascade=CascadeType.ALL)
    private Set<Task> taskSet;
}

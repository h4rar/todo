package com.smartworld.todo.todo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.*;

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
    private Long id;

    @Column(name = "date_of_creation", nullable = false)
    private Date dateOfCreation;

    @Column(name = "date_of_change")
    private Date  dateOfChange;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy="taskList")
    @JsonManagedReference
    @JsonBackReference
    private List<Task> taskSet;
}

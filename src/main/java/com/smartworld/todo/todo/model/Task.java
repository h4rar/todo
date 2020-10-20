package com.smartworld.todo.todo.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

@Check(constraints = "importance>=1 AND importance<=5")
public class Task {
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

    @Column(name = "description")
    private String description;

    @Column(name = "importance")
    private int importance;

    @Column(name = "is_ready", columnDefinition = "boolean default 'false'", nullable = false)
    private boolean isReady;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;
}

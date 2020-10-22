package com.smartworld.todo.todo.repository;

import com.smartworld.todo.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository for task
 */
public interface TaskRepository extends JpaRepository<Task, UUID> {

}


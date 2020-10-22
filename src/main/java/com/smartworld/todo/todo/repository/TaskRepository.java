package com.smartworld.todo.todo.repository;

import com.smartworld.todo.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for task
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}


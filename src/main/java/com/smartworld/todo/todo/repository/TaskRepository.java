package com.smartworld.todo.todo.repository;

import com.smartworld.todo.todo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}


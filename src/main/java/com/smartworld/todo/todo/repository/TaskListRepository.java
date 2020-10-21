package com.smartworld.todo.todo.repository;

import com.smartworld.todo.todo.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {

}


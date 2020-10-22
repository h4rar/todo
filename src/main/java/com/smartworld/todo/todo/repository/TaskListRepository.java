package com.smartworld.todo.todo.repository;

import com.querydsl.core.types.dsl.*;
import com.smartworld.todo.todo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.*;

import java.util.UUID;

/**
 * Repository for task lists
 */
public interface TaskListRepository extends JpaRepository<TaskList, UUID>,
        QuerydslPredicateExecutor<TaskList>, QuerydslBinderCustomizer<QTaskList> {

    @Override
    default void customize(QuerydslBindings bindings, QTaskList root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>)StringExpression::containsIgnoreCase);
    }
}






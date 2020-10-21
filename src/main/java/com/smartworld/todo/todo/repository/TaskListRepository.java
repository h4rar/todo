package com.smartworld.todo.todo.repository;

import com.querydsl.core.types.dsl.*;
import com.smartworld.todo.todo.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.*;


public interface TaskListRepository extends JpaRepository<TaskList, Long>,
        QuerydslPredicateExecutor<TaskList>, QuerydslBinderCustomizer<QTaskList> {

    Page<TaskList> findAll(Pageable pageable);

    @Override
    default void customize(QuerydslBindings bindings, QTaskList root){
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    };
}






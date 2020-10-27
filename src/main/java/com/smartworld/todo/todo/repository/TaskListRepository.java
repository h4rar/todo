package com.smartworld.todo.todo.repository;

import com.querydsl.core.types.dsl.*;
import com.smartworld.todo.todo.model.*;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.*;

import java.time.LocalDate;
import java.util.*;

/**
 * Repository for task lists
 */
public interface TaskListRepository extends JpaRepository<TaskList, UUID>,
        QuerydslPredicateExecutor<TaskList>, QuerydslBinderCustomizer<QTaskList> {

    @Override
    default void customize(@NonNull QuerydslBindings bindings, @NonNull QTaskList root) {
        // Make case-insensitive 'like' filter for all string properties
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>)StringExpression::containsIgnoreCase);

        // Add 'between' and 'greater or equal' filter date property
        bindings.bind(root.dateOfChange, root.dateOfCreation).all((path, value) -> {
            Iterator<? extends LocalDate> it = value.iterator();
            LocalDate from = it.next();
            if (value.size() >= 2) {
                LocalDate to = it.next();
                return Optional.of(path.between(from, to)); // between
            } else {
                return Optional.of(path.goe(from)); // greater than or equal
            }
        });
    }
}



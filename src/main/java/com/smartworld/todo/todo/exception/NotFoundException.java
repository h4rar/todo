package com.smartworld.todo.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Исключение для ситуации "не найдено"
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    /**
     * Исключение для ситуации "не найдено"
     */
    public NotFoundException() {
        super("Not found");
    }
}

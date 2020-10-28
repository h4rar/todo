package com.smartworld.todo.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Исключение для ситуации "плохой запрос"
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectNameException extends RuntimeException {

    /**
     * Исключение для ситуации "плохой запрос"
     */
    public IncorrectNameException() {
        super("Name empty");
    }
}

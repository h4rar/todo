package com.smartworld.todo.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Исключение для ситуаций "не найдено"
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmptyReadyException extends RuntimeException {

    public EmptyReadyException() {
        super("Ready can not be empty!");
    }
}

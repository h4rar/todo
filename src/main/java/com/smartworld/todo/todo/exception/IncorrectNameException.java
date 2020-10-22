package com.smartworld.todo.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BAD_REQUEST Exception (IncorrectName)
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectNameException extends RuntimeException {

    /**
     *
     */
    public IncorrectNameException() {
        super("Name empty");
    }
}

package com.smartworld.todo.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * NOT_FOUND Exception
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    /**
     *
     */
    public NotFoundException() {
        super("Not found");
    }
}

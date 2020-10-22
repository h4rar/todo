package com.smartworld.todo.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BAD_REQUEST Exception (EmptyReady)
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmptyReadyException extends RuntimeException {

    /**
     *
     */
    public EmptyReadyException() {
        super("Ready can not be empty!");
    }
}

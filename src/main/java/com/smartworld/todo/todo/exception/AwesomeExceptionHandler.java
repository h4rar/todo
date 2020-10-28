package com.smartworld.todo.todo.exception;

import com.smartworld.todo.todo.exception.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Обработчик исключений
 */
@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<AwesomeException> handleNotFoundException() {
        return new ResponseEntity<>(new AwesomeException("Not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyReadyException.class)
    protected ResponseEntity<AwesomeException> handleEmptyReadyException() {
        return new ResponseEntity<>(new AwesomeException("Ready can not be empty!"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectNameException.class)
    protected ResponseEntity<AwesomeException> handleIncorrectNameException() {
        return new ResponseEntity<>(new AwesomeException("Name empty"), HttpStatus.BAD_REQUEST);
    }

    @Data
    @AllArgsConstructor
    public static class AwesomeException {
        private String message;
    }
}
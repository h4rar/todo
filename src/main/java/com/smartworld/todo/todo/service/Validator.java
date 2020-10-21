package com.smartworld.todo.todo.service;

import org.springframework.validation.BindingResult;

public interface Validator {
    void validationName(BindingResult bindingResult);
    void validationMarkDone(BindingResult bindingResult);
}

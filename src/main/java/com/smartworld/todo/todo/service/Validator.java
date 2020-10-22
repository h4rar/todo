package com.smartworld.todo.todo.service;

import org.springframework.validation.BindingResult;

/**
 * Validator
 */
public interface Validator {

    /**
     * check name
     *
     * @param bindingResult bindingResult
     */
    void validationName(BindingResult bindingResult);

    /**
     * chek MarkDone
     *
     * @param bindingResult bindingResult
     */
    void validationMarkDone(BindingResult bindingResult);
}

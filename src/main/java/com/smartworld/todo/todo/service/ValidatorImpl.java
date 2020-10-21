package com.smartworld.todo.todo.service;

import com.smartworld.todo.todo.exception.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class ValidatorImpl implements Validator {
    public void validationName(BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new IncorrectNameException();
        }
    }

    @Override
    public void validationMarkDone(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EmptyReadyException();
        }
    }
}

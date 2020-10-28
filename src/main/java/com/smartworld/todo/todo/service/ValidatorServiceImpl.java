package com.smartworld.todo.todo.service;

import com.smartworld.todo.todo.exception.*;
import com.smartworld.todo.todo.service.interfaces.ValidatorService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

/**
 * Имплементация ValidatorService
 */
@Service
public class ValidatorServiceImpl implements ValidatorService {

    @Override
    public void validationName(BindingResult bindingResult) {
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

package com.smartworld.todo.todo.service.interfaces;

import org.springframework.validation.BindingResult;

/**
 * Сервис валидации
 */
public interface ValidatorService {

    /**
     * Проверяет имя
     *
     * @param bindingResult
     */
    void validationName(BindingResult bindingResult);

    /**
     * Проверяет статус
     *
     * @param bindingResult
     */
    void validationMarkDone(BindingResult bindingResult);
}

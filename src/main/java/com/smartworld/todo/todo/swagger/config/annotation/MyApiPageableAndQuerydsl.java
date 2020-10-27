package com.smartworld.todo.todo.swagger.config.annotation;

import io.swagger.annotations.*;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams({
        @ApiImplicitParam(name = "dateOfChange", required = false, paramType = "query", value = "Параметр фильтрации по дате изменения. " +
                "Если указать в запросе 2 параметра, то в ответе будут все списки дел с датой изменения между этими параметрами" +
                "Если указать только один параметр, то получим записи с датой изменения больше или равным этому значению." +
                "\nПример: http://localhost:8080/test/?dateOfChange=2020-10-23&dateOfChange=2020-10-25"),
        @ApiImplicitParam(name = "dateOfCreation", required = false, paramType = "query", value = "Параметр фильтрации по дате создания. " +
                "Аналогично фильтрации по дате изменения."+
                "\nПример: http://localhost:8080/test/?dateOfCreation=2020-10-25"),
        @ApiImplicitParam(name = "page", required = false, paramType = "query", value = "Страница результатов, которую вы хотите получить (0..N). " +
                "\nПример: http://localhost:8080/?page=0"),
        @ApiImplicitParam(name = "size", required = false, paramType = "query", value = "Количество записей на странице. " +
                "\nПример:http://localhost:8080/?size=2"),
        @ApiImplicitParam(name = "sort", required = false, paramType = "query", value = "Критерии сортировки в формате: свойство (,asc|desc). " +
                "Нечувствителен к регистру, можно указать имя не полностью. " +
                "По умолчанию сортировка выполняется по дате создания, от новых к старым." +
                "\nПример: http://localhost:8080/?sort=name,desc")
})
public @interface MyApiPageableAndQuerydsl {
}

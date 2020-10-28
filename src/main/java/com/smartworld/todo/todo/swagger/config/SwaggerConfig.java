package com.smartworld.todo.todo.swagger.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Конфигурация swagger-a
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
//public class SwaggerConfig implements WebMvcConfigurer {

    private static ApiInfo apiInfo() {
        return new ApiInfo(
                "Todo API",
                "Description of Todo API",
                "0.0.1",
                "Terms of service",
                new Contact("Anton", "https://t.me/h4rar", "anton.h4rar@gmail.com"),
                "-",
                "-",
                Collections.emptyList()
        );
    }

    /**
     * Конфигурация swagger-a
     *
     * @return Docket
     */
    @Bean
    public static Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.smartworld.todo.todo.controller"))
                .paths(PathSelectors.ant("/**"))
                .build();
    }
}
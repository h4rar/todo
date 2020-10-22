package com.smartworld.todo.todo.config.swagger;

import org.springframework.context.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Config for Swagger
 */
@Configuration
public class SpringFoxConfig {

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
     * Configures Swagger
     *
     * @return Docket
     */
    @Bean
    public static Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().useDefaultResponseMessages(false);
    }
}
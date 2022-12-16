package com.exam.spring_delivery.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocConfig {
    private Info apiInfo() {
        return new Info().title("Delivery API")
                .description("API for managing deliveries")
                .version("0.1")
                .contact(new Contact().name("Vladyslav Ripskyi").email("vladrip12@gmail.com"));
    }

    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI().info(apiInfo());
    }
}

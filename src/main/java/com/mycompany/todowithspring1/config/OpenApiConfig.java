package com.mycompany.todowithspring1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Todo Uygulaması API Rehberi")
                        .version("1.0")
                        .description("Bu API, ToDo uygulamasının backend servislerini dökümante eder."));
    }
}

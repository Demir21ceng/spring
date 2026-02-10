package com.mycompany.todowithspring1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.io.IOException;

@Configuration
public class OpenApiConfig implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String url = "http://localhost:8082/todo";

        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
    }
}

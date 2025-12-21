package com.mycompany.todowithspring1.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
    scanBasePackages = "com.mycompany.todowithspring1"
)
@EnableJpaRepositories("com.mycompany.todowithspring1.repository")
@EntityScan("com.mycompany.todowithspring1.model")
public class TodoApplication {

    public static void main(String[] args) {
         SpringApplication.run(TodoApplication.class, args);
    }
}

package com.mycompany.todowithspring1.application;



import com.mycompany.todowithspring1.controller.TodoController;
import com.mycompany.todowithspring1.controller.DetailsController;
import com.mycompany.todowithspring1.ui.FrameTodo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.SwingUtilities;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
    scanBasePackages = "com.mycompany.todowithspring1"
)
@EnableJpaRepositories("com.mycompany.todowithspring1.repository")
@EntityScan("com.mycompany.todowithspring1.model")
public class TodoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TodoApplication.class, args);
        
         TodoController todoController = context.getBean(TodoController.class);
         DetailsController detailsController = context.getBean(DetailsController.class);
        // 3️⃣ GUI'yi başlat, controller parametre olarak ver
        SwingUtilities.invokeLater(() -> {
            FrameTodo frame = new FrameTodo(todoController,detailsController);
            frame.setVisible(true);
        });
    }
}

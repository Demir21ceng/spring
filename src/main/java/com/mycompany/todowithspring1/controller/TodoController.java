/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todowithspring1.controller;

import com.mycompany.todowithspring1.model.*;
import com.mycompany.todowithspring1.services.TodoServices;
import java.util.List;

import org.springframework.stereotype.Controller;


/**
 *
 * @author servan
 */
@Controller
public class TodoController {
    private final TodoServices services;
    
    public TodoController(TodoServices services){
        this.services = services;
    }
    
     public Todo createTodo(String duty, Importance importance, CompletionStatus status) {
        return services.createTodo(duty, importance, status);
    }

    // ---- UPDATE Importance ----
    public Todo updateImportance(String duty, Importance newImportance) {
        return services.updateImportance(duty, newImportance);
    }

    // ---- UPDATE Completion Status ----
    public Todo updateCompletionStatus(String duty, CompletionStatus newStatus) {
        return services.updateCompletionStatus(duty, newStatus);
    }

    // ---- DELETE ----
    public void deleteTodo(String duty) {
        services.deleteTodo(duty);
    }

    // ---- LIST ALL ----
    public List<Todo> getAllTodos() {
        return services.getAllTodos();
    }

    // ---- LIST ONLY IMPORTANT ----
    public List<Todo> getImportantTodos() {
        return services.getImportantTodos();
    }
    
    // ---- GET TODO BY DUTY ----
    public Todo findTodobyDuty(String duty){
        return services.findTodoByDuty(duty);
    }
}

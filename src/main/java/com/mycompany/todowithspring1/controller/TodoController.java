package com.mycompany.todowithspring1.controller;

import com.mycompany.todowithspring1.dto.CreateTodoRequest;
import com.mycompany.todowithspring1.dto.TodoUpdateStatusRequest;
import com.mycompany.todowithspring1.dto.TodoUptadeImportanceRequest;
import com.mycompany.todowithspring1.dto.TodoDeleteRequest;
import com.mycompany.todowithspring1.model.*;
import com.mycompany.todowithspring1.services.TodoServices;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author servan
 */
@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoServices services;

    public TodoController(@Qualifier("todoServices") TodoServices services) {
        this.services = services;
    }

    @PostMapping("/create")

    public String createTodo(
            @Valid @ModelAttribute("todo") CreateTodoRequest request,
            BindingResult bindingResult,
            Model model
    ) {

        if (bindingResult.hasErrors()) {
            // Hataları JSP’ye geri gönder
            return "test"; // formun olduğu JSP
        }

        services.createTodo(
                request.getDuty(),
                request.getImportance(),
                request.getCompletionStatus()
        );

        return "redirect:/todo";
    }

    // ---------- EDİT -----------
    @GetMapping("/edit")
    public String editTodo(@RequestParam String duty, Model model) {
        Todo todo = services.findTodoByDuty(duty);
        model.addAttribute("todo", todo);
        return "todo-edit";
    }

    // --------- UPDATE IMPORTANCE----------
    @PostMapping("/update/importance")
    public String updateImportance(
            @Valid @ModelAttribute TodoUptadeImportanceRequest request,
            BindingResult result
    ) {
        if(result.hasErrors()) {
            return "redirect:/todo";
        }
        services.updateImportance(request.getDuty(),request.getImportance());
        return "redirect:/todo";
    }

    // --------- UPDATE COMPLLETİON STATUS----------
    @PostMapping("/update/status")
    public String updateStatus(
           @Valid @ModelAttribute TodoUpdateStatusRequest request,
           BindingResult result
    ) {
        if(result.hasErrors()) {
            return "redirect:/todo";
        }
        services.updateCompletionStatus(request.getDuty(), CompletionStatus.completed);
        return "redirect:/todo";
    }

    // ---- DELETE ----
    @GetMapping("/delete")
    public String deleteTodo(@Valid  TodoDeleteRequest request) {
        services.deleteTodo(request.getDuty());
        return "redirect:/todo";
    }

    // ---- LIST ALL ----
    @GetMapping
    public String todoList(Model model) {
        List<Todo> todos = services.getAllTodos();
        model.addAttribute("todos", todos);
        return "test"; // JSP adı
    }

    // ---- LIST ONLY IMPORTANT ----
    @GetMapping("/important")
    public String getImportantTodos(Model model) {
        List<Todo> todos = services.getImportantTodos();
        model.addAttribute("todos", todos);
        return "test"; // JSP adı
    }

    // ---- GET TODO BY DUTY ----
    public Todo findTodobyDuty(String duty) {
        return services.findTodoByDuty(duty);
    }
}

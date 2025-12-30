package com.mycompany.todowithspring1.controller;

import com.mycompany.todowithspring1.model.*;
import com.mycompany.todowithspring1.services.TodoServices;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author servan
 */
@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoServices services;

    public TodoController(TodoServices services) {
        this.services = services;
    }

    @PostMapping("/create")
    public String createTodo(
            @RequestParam("duty") String duty,
            @RequestParam("importance") Importance importance,
            @RequestParam(value = "completionStatus", required = false) CompletionStatus completionStatus
    ) {

        if (completionStatus == null) {
            completionStatus = CompletionStatus.continues;
        }

        services.createTodo(duty, importance, completionStatus);
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
            @RequestParam("duty") String duty,
            @RequestParam("importance") Importance importance
    ) {
        services.updateImportance(duty, importance);
        return "redirect:/todo";
    }

    // --------- UPDATE COMPLLETİON STATUS----------
    @PostMapping("/update/status")
    public String updateStatus(
            @RequestParam("duty") String duty
    ) {
        services.updateCompletionStatus(duty, CompletionStatus.completed);
        return "redirect:/todo";
    }

    // ---- DELETE ----
    @GetMapping("/delete")
    public String deleteTodo(@RequestParam("duty") String duty) {
        services.deleteTodo(duty);
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
    public List<Todo> getImportantTodos() {
        return services.getImportantTodos();
    }

    // ---- GET TODO BY DUTY ----
    public Todo findTodobyDuty(String duty) {
        return services.findTodoByDuty(duty);
    }
}

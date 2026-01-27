package com.mycompany.todowithspring1.controller;

import com.mycompany.todowithspring1.dto.CreateTodoRequest;
import com.mycompany.todowithspring1.dto.TodoResponse;
import com.mycompany.todowithspring1.dto.TodoUpdateStatusRequest;
import com.mycompany.todowithspring1.model.*;
import com.mycompany.todowithspring1.services.TodoServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@Tag(name = "Todo REST API", description = "Todo işlemleri için JSON tabanlı REST API")
public class TodoRestController {

    private final TodoServices services;

    public TodoRestController(@Qualifier("todoServices") TodoServices services) {
        this.services = services;
    }

    // ---- LIST ALL ----
    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAll() {
        return ResponseEntity.ok(services.getAllTodos());
    }

    // ---- CREATE ----
    @PostMapping
    @Operation(summary = "Yeni bir todo oluşturur")
    public ResponseEntity<Void> createTodo(
            @Valid @RequestBody CreateTodoRequest request
    ) {
        services.createTodo(
                request.getDuty(),
                request.getImportance(),
                request.getCompletionStatus() == null
                        ? CompletionStatus.continues
                        : request.getCompletionStatus()
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // ---- GET BY DUTY ----
    @GetMapping("/{duty}")
    @Operation(summary = "Görev adına göre todo getirir")
    public ResponseEntity<Todo> findByDuty(@PathVariable String duty) {
        return ResponseEntity.ok(services.findTodoByDuty(duty));
    }

    // ---- UPDATE STATUS ----
    @PatchMapping("/{duty}/status")
    @Operation(summary = "Todo durumunu günceller")
    public ResponseEntity<Void> updateStatus(
            @PathVariable String duty,
            @Valid @RequestBody TodoUpdateStatusRequest request
    ) {
        services.updateCompletionStatus(duty, CompletionStatus.completed);
        return ResponseEntity.noContent().build();
    }

    // ---- DELETE ----
    @DeleteMapping("/{duty}")
    @Operation(summary = "Todo siler")
    public ResponseEntity<Void> deleteTodo(@PathVariable String duty) {
        services.deleteTodo(duty);
        return ResponseEntity.noContent().build();
    }

    // ---- LIST IMPORTANT ----
    @GetMapping("/important")
    @Operation(summary = "Sadece önemli todoları listeler")
    public ResponseEntity<List<TodoResponse>> getImportant() {
        return ResponseEntity.ok(services.getImportantTodos());
    }
}

package com.mycompany.todowithspring1.controller;

import com.mycompany.todowithspring1.model.*;
import com.mycompany.todowithspring1.services.TodoServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@Tag(name = "Todo REST API", description = "Todo işlemleri için veriyi JSON olarak sunan API")
public class TodoRestController {

    private final TodoServices services;

    // Mevcut servis yapını aynen kullanıyoruz
    public TodoRestController(@Qualifier("todoServices") TodoServices services) {
        this.services = services;
    }

    // ---- LIST ALL (JSON Çıktısı) ----
    @GetMapping
    @Operation(summary = "Tüm todoları listeler")
    public List<Todo> getAll() {
        return services.getAllTodos(); // JSP adı yerine direkt listeyi dönüyoruz
    }

    // ---- CREATE (JSON Body ile) ----
    @PostMapping("/create")
    @Operation(summary = "Yeni bir todo oluşturur")
    public String createTodo(@RequestBody Todo todo) {
        // REST'te null kontrolü elledir veya modelde default atanır
        if (todo.getCompletionStatus() == null) {
            todo.setCompletionStatus(CompletionStatus.continues);
        }
        services.createTodo(todo.getDuty(), todo.getImportance(), todo.getCompletionStatus());
        return "Todo başarıyla oluşturuldu!";
    }

    // ---- GET BY DUTY (Detay Sorgulama) ----
    @GetMapping("/find")
    @Operation(summary = "Görev adına göre arama yapar")
    public Todo findByDuty(@RequestParam String duty) {
        return services.findTodoByDuty(duty);
    }

    // ---- UPDATE STATUS (Sadece durum güncelleme) ----
    @PatchMapping("/update/status") // REST'te kısmi güncellemeler için Patch kullanılır
    @Operation(summary = "Görevi tamamlandı olarak işaretler")
    public String updateStatus(@RequestParam String duty) {
        services.updateCompletionStatus(duty, CompletionStatus.completed);
        return duty + " durumu tamamlandı olarak güncellendi.";
    }

    // ---- DELETE ----
    @DeleteMapping("/delete")
    @Operation(summary = "Görevi siler")
    public String deleteTodo(@RequestParam String duty) {
        services.deleteTodo(duty);
        return duty + " başarıyla silindi.";
    }

    // ---- LIST IMPORTANT ----
    @GetMapping("/important")
    @Operation(summary = "Sadece önemli todoları listeler")
    public List<Todo> getImportant() {
        return services.getImportantTodos();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todowithspring1.services.impl;
import com.mycompany.todowithspring1.Exception.NotFoundException;
import com.mycompany.todowithspring1.model.Todo;
import com.mycompany.todowithspring1.model.Importance;
import com.mycompany.todowithspring1.model.CompletionStatus;
import com.mycompany.todowithspring1.services.TodoServices;
import com.mycompany.todowithspring1.repository.TodoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author servan
 */
@Service("todoServices")
public class TodoServicesImpl implements TodoServices{

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServicesImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Override
    public Todo createTodo(String duty, Importance importance, CompletionStatus completionStatus) {
        if (duty == null || duty.isBlank()) {
            throw new IllegalArgumentException("Duty cannot be empty");
        }
        if (importance == null) {
            throw new IllegalArgumentException("Importance cannot be null");
        }
        if (completionStatus == null) {
            completionStatus = CompletionStatus.continues;
        }
        if (todoRepository.findByDuty(duty).isPresent()) {
            throw new IllegalArgumentException("Todo with this duty already exists");
        }
        Todo todo = new Todo(duty, importance, completionStatus);
        return todoRepository.save(todo);
    }


    @Override
    public Todo findTodoByDuty(String duty) {
        return todoRepository.findByDuty(duty).orElseThrow(() -> new NotFoundException("Todo not found"));
    }
    
    @Override
    @Transactional
    public Todo updateImportance(String duty, Importance importance) {
        Todo todo = findTodoByDuty(duty);
        todo.setImportance(importance);
        return todo;
    }

    @Override
    @Transactional
    public Todo updateCompletionStatus(String duty, CompletionStatus completionStatus) {
        Todo todo = findTodoByDuty(duty);
        todo.setCompletionStatus(completionStatus);
        return todo;
    }

    @Override
    public void deleteTodo(String duty) {
        Todo todo = findTodoByDuty(duty);
        todoRepository.delete(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
          return todoRepository.findAll();
    }
    
     @Override
     public List<Todo> getImportantTodos() {
      return todoRepository.findTodosByImportance(Importance.important);
    }
    
}

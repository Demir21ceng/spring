/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todowithspring1.services.impl;
import com.mycompany.todowithspring1.model.Todo;
import com.mycompany.todowithspring1.model.Importance;
import com.mycompany.todowithspring1.model.CompletionStatus;
import com.mycompany.todowithspring1.services.TodoServices;
import com.mycompany.todowithspring1.repository.TodoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author servan
 */
@Service
public class TodoServicesImpl implements TodoServices{

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServicesImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    
    @Override
    public Todo createTodo(String duty,Importance importance, CompletionStatus completionStatus) {
        Todo todo = new Todo(duty,importance,completionStatus);
        return todoRepository.save(todo);
    }

    @Override
    public Todo findTodoByDuty(String duty) {
        return todoRepository.findByDuty(duty).orElseThrow(() -> new RuntimeException("Todo not found"));
    }
    
    @Override
    public Todo updateImportance(String duty, Importance importance) {
        Todo todo = findTodoByDuty(duty);
        todo.setImportance(importance);
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateCompletionStatus(String duty, CompletionStatus completionStatus) {
        Todo todo = findTodoByDuty(duty);
        todo.setCompletionStatus(completionStatus);
        return todoRepository.save(todo);
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
        return todoRepository.findAll()
                .stream()
                .filter(todo -> todo.getImportance() == Importance.important)
                .collect(Collectors.toList());
    }
    
}

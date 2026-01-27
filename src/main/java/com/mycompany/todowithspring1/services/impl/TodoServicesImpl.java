package com.mycompany.todowithspring1.services.impl;

import com.mycompany.todowithspring1.Exception.ConflictException;
import com.mycompany.todowithspring1.Exception.NotFoundException;
import com.mycompany.todowithspring1.dto.TodoResponse;
import com.mycompany.todowithspring1.model.Todo;
import com.mycompany.todowithspring1.model.Importance;
import com.mycompany.todowithspring1.model.CompletionStatus;
import com.mycompany.todowithspring1.services.TodoServices;
import com.mycompany.todowithspring1.repository.TodoRepository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("todoServices")
public class TodoServicesImpl implements TodoServices {

    private final TodoRepository todoRepository;

    private static final Logger log =
            LoggerFactory.getLogger(TodoServicesImpl.class);

    @Autowired
    public TodoServicesImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // ================= CREATE =================
    @Override
    public Todo createTodo(String duty, Importance importance, CompletionStatus completionStatus) {

        log.info("Creating todo with duty='{}'", duty);

        if (duty == null || duty.isBlank()) {
            throw new IllegalArgumentException("Duty cannot be empty");
        }

        if (completionStatus == null) {
            completionStatus = CompletionStatus.continues;
        }

        if (todoRepository.existsByDuty(duty)) {
            throw new ConflictException("Todo with this duty already exists");
        }

        Todo todo = new Todo(duty, importance, completionStatus);
        return todoRepository.save(todo);
    }

    // ================= READ =================
    @Override
    public Todo findTodoByDuty(String duty) {

        if (duty == null || duty.isBlank()) {
            throw new IllegalArgumentException("Duty cannot be empty");
        }

        return todoRepository.findByDuty(duty)
                .orElseThrow(() -> new NotFoundException("Todo not found"));
    }

    // ================= UPDATE =================
    @Override
    @Transactional
    public Todo updateImportance(String duty, Importance importance) {

        log.info("Updating importance | duty={} importance={}", duty, importance);

        Todo todo = findTodoByDuty(duty);
        todo.setImportance(importance);
        return todo;
    }

    @Override
    @Transactional
    public Todo updateCompletionStatus(String duty, CompletionStatus completionStatus) {

        log.info("Updating completion status | duty={} status={}", duty, completionStatus);

        Todo todo = findTodoByDuty(duty);
        todo.setCompletionStatus(completionStatus);
        return todo;
    }

    // ================= DELETE =================
    @Override
    public void deleteTodo(String duty) {

        log.info("Deleting todo with duty='{}'", duty);

        Todo todo = findTodoByDuty(duty);
        todoRepository.delete(todo);
    }

    // ================= LIST =================
    @Override
    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAllTodoDto();
    }

    @Override
    public List<TodoResponse> getImportantTodos() {
        return todoRepository.findTodoDtoByImportance(Importance.important);
    }

    // ================= PAGINATION =================

}

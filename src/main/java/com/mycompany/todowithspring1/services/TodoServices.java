package com.mycompany.todowithspring1.services;
import com.mycompany.todowithspring1.dto.TodoResponse;
import com.mycompany.todowithspring1.model.Todo;
import com.mycompany.todowithspring1.model.CompletionStatus;
import com.mycompany.todowithspring1.model.Importance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
/**
 *
 * @author servan
 */
@Component
public interface TodoServices {
    Todo createTodo(String duty,Importance importance, CompletionStatus completionStatus);
    Todo findTodoByDuty(String duty);
    Todo updateImportance(String duty, Importance importance);
    Todo updateCompletionStatus(String duty, CompletionStatus completionStatus);
    void deleteTodo(String duty);
    List<TodoResponse> getAllTodos();
    List<TodoResponse> getImportantTodos();

}

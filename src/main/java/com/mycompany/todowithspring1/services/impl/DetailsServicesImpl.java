/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todowithspring1.services.impl;


import com.mycompany.todowithspring1.services.DetailsServices;
import com.mycompany.todowithspring1.repository.DetailsRepository;
import com.mycompany.todowithspring1.repository.TodoRepository;
import com.mycompany.todowithspring1.model.Todo;
import com.mycompany.todowithspring1.model.Details;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author servan
 */
@Service("DetailsServices")
public class DetailsServicesImpl implements DetailsServices {

    private final TodoRepository todoRepository;
    private final DetailsRepository detailsRepository;

    public DetailsServicesImpl(TodoRepository todoRepository, DetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
        this.todoRepository = todoRepository;
    }

    @Override
    public Details createDetails(String details, String todoDuty) {
        Todo todo = todoRepository.findByDuty(todoDuty)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        Details detail = new Details();
        detail.setTitle(details);
        detail.setTodo(todo);
        //todo.addDetail(detail);
        return detailsRepository.save(detail);
    }

    @Override
    public void deleteDetails(String title, String todoDuty) {
        Todo todo = todoRepository.findByDuty(todoDuty)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        Details detail = detailsRepository.findByDetailsAndTodo(title, todo)
                .orElseThrow(() -> new RuntimeException("Detail not found"));
        detailsRepository.delete(detail);
    }

    @Override
    public List<Details> getDetailsByTodoDuty(String todoDuty) {
        Todo todo = todoRepository.findByDuty(todoDuty)
            .orElseThrow(() -> new RuntimeException("Todo not found"));

    return detailsRepository.findAllByTodo(todo);
    }

}

package com.mycompany.todowithspring1.repository;

import com.mycompany.todowithspring1.model.Details;
import com.mycompany.todowithspring1.model.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {
    Optional<Details> findByDetailsAndTodo(String title, Todo todo); 
     List<Details> findAllByTodo(Todo todo);
}

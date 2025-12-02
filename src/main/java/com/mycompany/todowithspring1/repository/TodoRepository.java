package com.mycompany.todowithspring1.repository;

import com.mycompany.todowithspring1.model.Todo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findByDuty(String duty);
}

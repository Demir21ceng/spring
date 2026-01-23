package com.mycompany.todowithspring1.repository;

import com.mycompany.todowithspring1.model.Importance;
import com.mycompany.todowithspring1.model.Todo;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findByDuty(String duty);

    // JPQL – OPTIMIZED QUERY
    @Query("SELECT t FROM Todo t WHERE t.importance = :importance")
    List<Todo> findTodosByImportance(@Param("importance") Importance importance);


}

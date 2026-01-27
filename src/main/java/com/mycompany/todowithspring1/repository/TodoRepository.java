package com.mycompany.todowithspring1.repository;

import com.mycompany.todowithspring1.dto.TodoResponse;
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
    @Query("""
        select new com.mycompany.todowithspring1.dto.TodoResponse(
            t.id,
            t.duty,
            t.importance,
            t.completionStatus,
            t.date
        )
        from Todo t
    """)
    List<TodoResponse> findAllTodoDto();

    @Query("""
        select new com.mycompany.todowithspring1.dto.TodoResponse(
            t.id,
            t.duty,
            t.importance,
            t.completionStatus,
            t.date
        )
        from Todo t
        where t.importance = :importance
    """)

    List<TodoResponse> findTodoDtoByImportance(@Param("importance") Importance importance);

    boolean existsByDuty(String duty);
}

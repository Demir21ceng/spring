package com.mycompany.todowithspring1.repository;

import com.mycompany.todowithspring1.dto.DetailsResponse;
import com.mycompany.todowithspring1.model.Details;
import com.mycompany.todowithspring1.model.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {

    // DELETE / UPDATE için
    Optional<Details> findById(Long id);

        @Query("""
        select new com.mycompany.todowithspring1.dto.DetailsResponse(d.id, d.details)
        from Details d
        join d.todo t
        where t.duty = :duty
    """)
        List<DetailsResponse> findDetailsDtoByDuty(@Param("duty") String duty);


}

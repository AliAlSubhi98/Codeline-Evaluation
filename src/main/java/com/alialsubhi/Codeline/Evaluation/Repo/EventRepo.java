package com.alialsubhi.Codeline.Evaluation.Repo;

import com.alialsubhi.Codeline.Evaluation.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepo extends JpaRepository <Event,Long> {

    @Query("SELECT e FROM Event e WHERE (:location IS NULL OR e.location = :location)"
            + " AND (:dateFrom IS NULL OR e.date >= :dateFrom)"
            + " AND (:dateTo IS NULL OR e.date <= :dateTo)"
            + " AND (:eventName IS NULL OR e.name LIKE CONCAT('%', :eventName, '%'))")
    List<Event> search(@Param("location") String location,
                       @Param("dateFrom") LocalDate dateFrom,
                       @Param("dateTo") LocalDate dateTo,
                       @Param("eventName") String eventName);
}

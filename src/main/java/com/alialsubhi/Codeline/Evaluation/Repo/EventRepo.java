package com.alialsubhi.Codeline.Evaluation.Repo;

import com.alialsubhi.Codeline.Evaluation.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository <Event,Long> {
}

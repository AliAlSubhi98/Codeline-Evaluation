package com.alialsubhi.Codeline.Evaluation.Repo;

import com.alialsubhi.Codeline.Evaluation.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <User,Long> {
}

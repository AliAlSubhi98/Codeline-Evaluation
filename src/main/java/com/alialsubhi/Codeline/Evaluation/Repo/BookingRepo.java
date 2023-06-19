package com.alialsubhi.Codeline.Evaluation.Repo;

import com.alialsubhi.Codeline.Evaluation.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository <Booking,Long> {
}

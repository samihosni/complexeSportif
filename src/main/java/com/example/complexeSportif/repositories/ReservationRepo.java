package com.example.complexeSportif.repositories;

import com.example.complexeSportif.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation,Long> {
}

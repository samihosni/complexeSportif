package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> getAllReservation();

    Optional<Reservation> getReservationById(Long id);

    Reservation saveReservation(Reservation reservation);

    void deleteReservation(Long id);
}

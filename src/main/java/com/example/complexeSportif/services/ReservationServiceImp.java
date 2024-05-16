package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.Pool;
import com.example.complexeSportif.entities.Reservation;
import com.example.complexeSportif.repositories.PoolRepo;
import com.example.complexeSportif.repositories.ReservationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ReservationServiceImp implements ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;
    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepo.findAll();
    }
    @Override

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepo.findById(id);
    }
    @Override

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }
    @Override

    public void deleteReservation(Long id) {
        reservationRepo.deleteById(id);
    }
}

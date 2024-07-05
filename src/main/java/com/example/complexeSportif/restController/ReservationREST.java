package com.example.complexeSportif.restController;

import com.example.complexeSportif.entities.Reservation;
import com.example.complexeSportif.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationREST {

    private final ReservationService reservationService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservation();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/show/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('ADHERANT')")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        return reservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADHERANT')")

    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.saveReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReservation);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADHERANT')")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        if (!reservationService.getReservationById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        reservation.setId(id);
        Reservation updatedReservation = reservationService.saveReservation(reservation);
        return ResponseEntity.ok(updatedReservation);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADHERANT') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        if (!reservationService.getReservationById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
// creating of reservation
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADHERANT') or hasRole('ADMIN')") // Autorisation pour les adhérents seulement
    public ResponseEntity<Reservation> createReservation(
            @RequestParam Long userId,
            @RequestParam Long terrainId,
            @RequestParam String typeTerrain,
            @RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(userId, terrainId, typeTerrain, reservation);
        return ResponseEntity.ok(createdReservation);
    }
}

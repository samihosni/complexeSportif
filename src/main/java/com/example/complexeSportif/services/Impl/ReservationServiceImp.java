package com.example.complexeSportif.services.Impl;

import com.example.complexeSportif.entities.Reservation;
import com.example.complexeSportif.entities.TerrainsFoot;
import com.example.complexeSportif.entities.TerrainsPadel;
import com.example.complexeSportif.repositories.ReservationRepo;
import com.example.complexeSportif.repositories.TerrainsFootRepo;
import com.example.complexeSportif.repositories.TerrainsPadelRepo;
import com.example.complexeSportif.services.ReservationService;
import com.example.complexeSportif.user.User;
import com.example.complexeSportif.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ReservationServiceImp implements ReservationService {

    private final ReservationRepo reservationRepo;
    private final UserRepo userRepo;
    private final TerrainsFootRepo terrainsFootRepository;
    private final TerrainsPadelRepo terrainsPadelRepository;
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
// reservation of Terrain padel  or Terrain foot
    @Override
    public Reservation createReservation(Long userId, Long terrainId, String typeTerrain, Reservation reservation) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        switch (typeTerrain) {
            case "FOOT":
                TerrainsFoot terrainFoot = terrainsFootRepository.findById(terrainId)
                        .orElseThrow(() -> new IllegalArgumentException("Terrain de foot non trouvé"));
                reservation.setTerrainFoot(terrainFoot);
                break;
            case "PADEL":
                TerrainsPadel terrainPadel = terrainsPadelRepository.findById(terrainId)
                        .orElseThrow(() -> new IllegalArgumentException("Terrain de padel non trouvé"));
                reservation.setTerrainPadel(terrainPadel);
                break;
            default:
                throw new IllegalArgumentException("Type de terrain non pris en charge: " + typeTerrain);
        }

        reservation.setUser(user);
        return reservationRepo.save(reservation);
    }
}

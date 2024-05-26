package com.example.complexeSportif.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TerrainsFoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean dispo;

    @ManyToOne
    @JoinColumn(name = "complexe_id")
    private ComplexeSportif complexeSportif;

    @OneToMany
    private List<Reservation> reservationsFoot;

}

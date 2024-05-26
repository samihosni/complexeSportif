package com.example.complexeSportif.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateRes;

    @ManyToOne
    @JoinColumn(name = "terrainFoot_id")
    private TerrainsFoot terrainsFoot;

    @ManyToOne
    @JoinColumn(name = "terrainPadel_id")
    private TerrainsPadel terrainsPadel;


}

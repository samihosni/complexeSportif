package com.example.complexeSportif.entities;


import com.example.complexeSportif.user.User;
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
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "terrain_foot_id")
    private TerrainsFoot terrainFoot;

    @ManyToOne
    @JoinColumn(name = "terrain_padel_id")
    private TerrainsPadel terrainPadel;


}

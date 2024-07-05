package com.example.complexeSportif.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TerrainsFoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean dispo;

    @ManyToOne
    @JoinColumn(name = "complexe_sportif_id")
    private ComplexeSportif complexeSportif;
    
}

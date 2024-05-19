package com.example.complexeSportif.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table
public class TerrainsPadel {
    @Id
    private Integer id;
    private String name;
    private Boolean dispo;
    // Relation
    @ManyToOne
    @JoinColumn(name = "complexe_sportif_id")
    private ComplexeSportif complexeSportif;

}

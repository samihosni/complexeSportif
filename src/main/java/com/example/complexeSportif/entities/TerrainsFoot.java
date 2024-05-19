package com.example.complexeSportif.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class TerrainsFoot {
    @Id
    private Integer id;
    private String name;
    private Boolean dispo;
    // Relation
    @ManyToOne
    @JoinColumn(name = "complexe_sportif_id")
    private ComplexeSportif complexeSportif;
}

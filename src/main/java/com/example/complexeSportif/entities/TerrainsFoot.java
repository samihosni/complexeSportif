package com.example.complexeSportif.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TerrainsFoot {
    @Id
    private Integer id;
    private String name;
    private Boolean dispo;
}

package com.example.complexeSportif.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
}

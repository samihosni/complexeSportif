package com.example.complexeSportif.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

}

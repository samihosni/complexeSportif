package com.example.complexeSportif.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComplexeSportif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String adress;
    private Integer phone;

    @OneToMany()
    private List<TerrainsPadel> terrainsPadels;

    @OneToMany()
    private List<TerrainsFoot> terrainsFoots;


}

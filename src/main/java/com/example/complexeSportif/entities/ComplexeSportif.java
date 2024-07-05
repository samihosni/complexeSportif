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


    @OneToMany(mappedBy = "complexeSportif", cascade = CascadeType.ALL)
    private List<SalleMuscu> sallesMuscu;

    @OneToMany(mappedBy = "complexeSportif", cascade = CascadeType.ALL)
    private List<Pool> pool;

    @OneToMany(mappedBy = "complexeSportif", cascade = CascadeType.ALL)
    private List<TerrainsFoot> terrainsFoots;

    @OneToMany(mappedBy = "complexeSportif", cascade = CascadeType.ALL)
    private List<TerrainsPadel> terrainsPadels;


}

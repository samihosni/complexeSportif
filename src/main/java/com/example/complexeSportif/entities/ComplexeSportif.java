package com.example.complexeSportif.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class ComplexeSportif {
    @Id
    private Long id;
    private String name;
    private String adress;
    private Integer phone;
    // Relations
    @OneToMany(mappedBy = "complexeSportif", cascade = CascadeType.ALL)
    private List<TerrainsPadel> terrainsPadel;

    @OneToMany(mappedBy = "complexeSportif", cascade = CascadeType.ALL)
    private List<TerrainsFoot> terrainsFoot;

    @OneToOne(mappedBy = "complexeSportif", cascade = CascadeType.ALL)
    private SalleMuscu salleMuscu;

    @OneToOne(mappedBy = "complexeSportif", cascade = CascadeType.ALL)
    private Pool pool;
}

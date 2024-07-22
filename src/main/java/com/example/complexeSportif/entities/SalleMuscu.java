package com.example.complexeSportif.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class SalleMuscu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer maxCapacity;

    @ManyToOne
    @JoinColumn(name = "complexe_sportif_id")
    private ComplexeSportif complexeSportif;

    @OneToMany(mappedBy = "salleMuscu")
    private List<Courses> courses;

 

}

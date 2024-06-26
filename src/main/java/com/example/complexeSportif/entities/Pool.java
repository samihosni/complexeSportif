package com.example.complexeSportif.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double temp;
    private Boolean capacity;

    @OneToOne(mappedBy = "pool", cascade = CascadeType.ALL)
    private Subscriptions subscriptions;


}

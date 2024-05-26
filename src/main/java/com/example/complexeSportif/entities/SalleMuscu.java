package com.example.complexeSportif.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalleMuscu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer maxCapacity;

    @OneToOne(mappedBy = "salleMuscu", cascade = CascadeType.ALL)
    private Subscriptions subscriptions;

}

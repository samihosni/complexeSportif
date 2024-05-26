package com.example.complexeSportif.entities;

import com.example.complexeSportif.entities.Enum.PaymentType;
import com.example.complexeSportif.entities.Enum.SubscriptionType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateStart;
    private Date dateEnd;
    private double costs;
    private SubscriptionType subscriptionType;
    private PaymentType paymentType;

    @OneToOne
    @JoinColumn(name = "pool_id")
    private Pool pool;

    @OneToOne
    @JoinColumn(name = "salleMusc_id")
    private SalleMuscu salleMuscu;

}

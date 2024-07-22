package com.example.complexeSportif.entities;

import com.example.complexeSportif.entities.Enum.PaymentType;
import com.example.complexeSportif.entities.Enum.SubscriptionType;
import com.example.complexeSportif.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateStart;
    private Date dateEnd;
    private double costs;
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "salle_muscu_id")
    private SalleMuscu salleMuscu;

    @ManyToOne
    @JoinColumn(name = "pool_id")
    private Pool pool;



}

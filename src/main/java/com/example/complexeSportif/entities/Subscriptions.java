package com.example.complexeSportif.entities;

import com.example.complexeSportif.entities.Enum.PaymentType;
import com.example.complexeSportif.entities.Enum.SubscriptionType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}

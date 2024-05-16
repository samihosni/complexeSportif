package com.example.complexeSportif.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
public class Subscriptions {
    @Id
    private Long id;
    private Date dateStart;
    private Date dateEnd;
    private double costs;
    private SubscriptionType subscriptionType;
    private PaymentType paymentType;
}

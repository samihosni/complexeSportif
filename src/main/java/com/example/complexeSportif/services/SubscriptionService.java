package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.Subscriptions;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {
    List<Subscriptions> getAllSubscriptions();

    Optional<Subscriptions> getSubscriptionById(Long id);

    Subscriptions saveSubscription(Subscriptions subscriptions);

    void deleteSubscription(Long id);
}

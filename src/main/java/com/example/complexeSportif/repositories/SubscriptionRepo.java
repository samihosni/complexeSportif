package com.example.complexeSportif.repositories;

import com.example.complexeSportif.entities.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepo extends JpaRepository<Subscriptions, Long> {
}

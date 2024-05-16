package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.SalleMuscu;
import com.example.complexeSportif.entities.Subscriptions;
import com.example.complexeSportif.repositories.SalleMuscuRepo;
import com.example.complexeSportif.repositories.SubscriptionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImp implements SubscriptionService {
    @Autowired
    private SubscriptionRepo subscriptionRepo;
    @Override
    public List<Subscriptions> getAllSubscriptions() {
        return subscriptionRepo.findAll();
    }
    @Override

    public Optional<Subscriptions> getSubscriptionById(Long id) {
        return subscriptionRepo.findById(id);
    }
    @Override

    public Subscriptions saveSubscription(Subscriptions subscriptions) {
        return subscriptionRepo.save(subscriptions);
    }
    @Override

    public void deleteSubscription(Long id) {
        subscriptionRepo.deleteById(id);
    }
}

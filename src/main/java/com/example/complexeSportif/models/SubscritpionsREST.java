package com.example.complexeSportif.models;


import com.example.complexeSportif.entities.Subscriptions;
import com.example.complexeSportif.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subscriptions")
public class SubscritpionsREST {
    @Autowired
    private SubscriptionService subscriptionService;
    @GetMapping("/all")
    public ResponseEntity<List<Subscriptions>> getAllSubscriptions() {
        List<Subscriptions> subscriptions = subscriptionService.getAllSubscriptions();
        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscriptions> getSubscriptionById(@PathVariable Long id) {
        Optional<Subscriptions> subscription = subscriptionService.getSubscriptionById(id);
        return subscription.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Subscriptions> createSubscription(@RequestBody Subscriptions subscription) {
        Subscriptions savedSubscription = subscriptionService.saveSubscription(subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubscription);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Subscriptions> updateSubscription(@PathVariable Long id, @RequestBody Subscriptions subscription) {
        if (!subscriptionService.getSubscriptionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        subscription.setId(id);
        Subscriptions updatedSubscription = subscriptionService.saveSubscription(subscription);
        return ResponseEntity.ok(updatedSubscription);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
        if (!subscriptionService.getSubscriptionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }

}

package com.example.complexeSportif.restController;


import com.example.complexeSportif.entities.Enum.SubscriptionType;
import com.example.complexeSportif.entities.Subscriptions;
import com.example.complexeSportif.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscritpionsREST {

    private final SubscriptionService subscriptionService;
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Subscriptions>> getAllSubscriptions() {
        List<Subscriptions> subscriptions = subscriptionService.getAllSubscriptions();
        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/show/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('ADHERANT')")
    public ResponseEntity<Subscriptions> getSubscriptionById(@PathVariable Long id) {
        Optional<Subscriptions> subscription = subscriptionService.getSubscriptionById(id);
        return subscription.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Subscriptions> createSubscription(@RequestBody Subscriptions subscription) {
        Subscriptions savedSubscription = subscriptionService.saveSubscription(subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubscription);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
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

    // create a subscription

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADHERANT')")
    public ResponseEntity<Subscriptions> createSubscription(
            @RequestParam Long userId,
            @RequestParam(required = false) Long salleMuscuId,
            @RequestParam(required = false) Long poolId,
            @RequestParam SubscriptionType subscriptionType,
            @RequestBody Subscriptions subscription) {
        Subscriptions createdSubscription = subscriptionService.createSubscription(userId, salleMuscuId, poolId, subscriptionType);
        return ResponseEntity.ok(createdSubscription);
    }

}

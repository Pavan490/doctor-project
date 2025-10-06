package com.longbow.subscription_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.longbow.subscription_service.entity.Subscription;
import com.longbow.subscription_service.service.SubscriptionService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        Subscription savedSubscription = subscriptionService.saveSubscription(subscription);
        return ResponseEntity.ok(savedSubscription);
    }

    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Integer id) {
        Optional<Subscription> subscriptionOpt = subscriptionService.getSubscriptionById(id);
        if (subscriptionOpt.isPresent()) {
            return ResponseEntity.ok(subscriptionOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable Integer id,
                                                           @RequestBody Subscription subscription) {
        try {
            Subscription updatedSubscription = subscriptionService.updateSubscription(id, subscription);
            return ResponseEntity.ok(updatedSubscription);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

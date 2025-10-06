package com.longbow.subscription_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longbow.subscription_service.entity.Subscription;
import com.longbow.subscription_service.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> getSubscriptionById(Integer id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public Subscription updateSubscription(Integer id, Subscription subscription) {
        Optional<Subscription> existingSubOpt = subscriptionRepository.findById(id);
        if (existingSubOpt.isPresent()) {
            Subscription existingSub = existingSubOpt.get();

            // Update entity fields
            existingSub.setDOCTOR_ID(subscription.getDOCTOR_ID());
            existingSub.setPLAN_ID(subscription.getPLAN_ID());
            existingSub.setPLAN_PRICEE(subscription.getPLAN_PRICEE());
            existingSub.setDISCOUNT_AMOUNT(subscription.getDISCOUNT_AMOUNT());
            existingSub.setCOUPON_ID(subscription.getCOUPON_ID());
            existingSub.setPLAN_START_DATE(subscription.getPLAN_START_DATE());
            existingSub.setPLAN_END_DATE(subscription.getPLAN_END_DATE());
            existingSub.setINVOICE(subscription.getINVOICE());
            existingSub.setIS_ACTIVE(subscription.getIS_ACTIVE());
            existingSub.setUPDATED_AT(new java.util.Date()); // set updated time

            return subscriptionRepository.save(existingSub);
        } else {
            throw new RuntimeException("Subscription not found with id: " + id);
        }
    }

    @Override
    public String deleteSubscription(Integer id) {
        Optional<Subscription> existingSubOpt = subscriptionRepository.findById(id);
        if (existingSubOpt.isPresent()) {
            subscriptionRepository.deleteById(id);
            return "Subscription deleted successfully!";
        } else {
            return "Subscription not found with id: " + id;
        }
    }
}

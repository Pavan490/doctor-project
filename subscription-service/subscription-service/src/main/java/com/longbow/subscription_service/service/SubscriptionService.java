package com.longbow.subscription_service.service;

import java.util.List;
import java.util.Optional;
import com.longbow.subscription_service.entity.Subscription;

public interface SubscriptionService {

    Subscription saveSubscription(Subscription subscription);

    List<Subscription> getAllSubscriptions();

    Optional<Subscription> getSubscriptionById(Integer id);

    Subscription updateSubscription(Integer id, Subscription subscription);

    String deleteSubscription(Integer id);
}

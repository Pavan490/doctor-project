package com.longbow.subscription_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.longbow.subscription_service.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

}

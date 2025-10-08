package com.longbow.plan_feature_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.longbow.plan_feature_service.Entity.PlanFeature;

public interface PlanFeatureRepository extends JpaRepository<PlanFeature, Integer> {

}

package com.longbow.plan_service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longbow.plan_service.Entity.Plans;
import com.longbow.plan_service.Repository.PlansRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlansServiceImpl implements PlansService {

    @Autowired
    private PlansRepository plansRepository;

    @Override
    public Plans createPlan(Plans plan) {
        return plansRepository.save(plan);
    }

    @Override
    public List<Plans> getAllPlans() {
        return plansRepository.findAll();
    }

    @Override
    public Optional<Plans> getPlanById(int planId) {
        return plansRepository.findById(planId);
    }

    @Override
    public Plans updatePlan(int planId, Plans updatedPlan) {
        if (plansRepository.existsById(planId)) {
            updatedPlan.setPlanId(planId); // ensure the correct ID
            return plansRepository.save(updatedPlan);
        }
        return null; // or throw custom exception
    }

    @Override
    public void deletePlan(int planId) {
        plansRepository.deleteById(planId);
    }

    @Override
    public List<Plans> getActivePlans(boolean isActive) {
        return plansRepository.findByIsActive(isActive);
    }
}


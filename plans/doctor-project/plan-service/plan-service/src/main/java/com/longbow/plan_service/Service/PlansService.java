package com.longbow.plan_service.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.longbow.plan_service.DTO.PlansDTO;
import com.longbow.plan_service.Entity.Plans;

@Service
public interface PlansService {


    PlansDTO createPlan(PlansDTO planDTO);

    List<PlansDTO> getAllPlans();

    PlansDTO getPlanById(int planId);

    PlansDTO updatePlan(int planId, PlansDTO planDTO);

    void deletePlan(int planId);

    // ✅ Extra: Find by active status
    List<PlansDTO> getActivePlans(boolean isActive);

}


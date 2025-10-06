package com.longbow.plan_service.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.longbow.plan_service.Entity.Plans;

@Service
public interface PlansService {

    // ✅ Create
    Plans createPlan(Plans plan);

    // ✅ Read (all)
    List<Plans> getAllPlans();

    // ✅ Read (by ID)
    Optional<Plans> getPlanById(int planId);

    // ✅ Update
    Plans updatePlan(int planId, Plans updatedPlan);

    // ✅ Delete
    void deletePlan(int planId);

    // ✅ Extra: Find by active status
    List<Plans> getActivePlans(boolean isActive);
}


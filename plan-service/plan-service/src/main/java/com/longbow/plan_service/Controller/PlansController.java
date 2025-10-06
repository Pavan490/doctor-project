package com.longbow.plan_service.Controller;
import com.longbow.plan_service.Entity.Plans;
import com.longbow.plan_service.Service.PlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plans")
public class PlansController {

    @Autowired
    private PlansService plansService;

    // ✅ Create a new plan
    @PostMapping
    public ResponseEntity<Plans> createPlan(@RequestBody Plans plan) {
    	Plans savedPlan = plansService.createPlan(plan);
        return ResponseEntity.ok(savedPlan);
    }

    // ✅ Get all plans
    @GetMapping
    public ResponseEntity<List<Plans>> getAllPlans() {
        return ResponseEntity.ok(plansService.getAllPlans());
    }

    // ✅ Get plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<Plans> getPlanById(@PathVariable int id) {
        Optional<Plans> plan = plansService.getPlanById(id);
        return plan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Update plan
    @PutMapping("/{id}")
    public ResponseEntity<Plans> updatePlan(@PathVariable int id, @RequestBody Plans updatedPlan) {
    	Plans plan = plansService.updatePlan(id, updatedPlan);
        if (plan != null) {
            return ResponseEntity.ok(plan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ Delete plan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable int id) {
        plansService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Get active/inactive plans
    @GetMapping("/status/{active}")
    public ResponseEntity<List<Plans>> getActivePlans(@PathVariable boolean active) {
        return ResponseEntity.ok(plansService.getActivePlans(active));
    }
}


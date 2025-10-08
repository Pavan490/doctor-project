package com.longbow.plan_service.Controller;
import com.longbow.plan_service.DTO.PlansDTO;
import com.longbow.plan_service.Service.PlansService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlansController {

    @Autowired
    private PlansService plansService;

    // ✅ Create a new plan
    @PostMapping
    public ResponseEntity<PlansDTO> createPlan(@Valid @RequestBody PlansDTO planDTO) {
        PlansDTO createdPlan = plansService.createPlan(planDTO);
        return ResponseEntity.ok(createdPlan);
    }

    // ✅ Get all plans
    @GetMapping
    public ResponseEntity<List<PlansDTO>> getAllPlans() {
        List<PlansDTO> plans = plansService.getAllPlans();
        return ResponseEntity.ok(plans);
    }

    // ✅ Get a plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<PlansDTO> getPlanById(@PathVariable int id) {
        PlansDTO plan = plansService.getPlanById(id);
        return ResponseEntity.ok(plan);
    }

    // ✅ Update a plan by ID
    @PutMapping("/{id}")
    public ResponseEntity<PlansDTO> updatePlan(@PathVariable int id, @Valid @RequestBody PlansDTO planDTO) {
        PlansDTO updatedPlan = plansService.updatePlan(id, planDTO);
        return ResponseEntity.ok(updatedPlan);
    }

    // ✅ Delete a plan by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable int id) {
        plansService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
    
 // ✅ Get plans by active status
    @GetMapping("/status/{isActive}")
    public ResponseEntity<List<PlansDTO>> getPlansByStatus(@PathVariable boolean isActive) {
        List<PlansDTO> plans = plansService.getActivePlans(isActive);
        return ResponseEntity.ok(plans);
    }

}

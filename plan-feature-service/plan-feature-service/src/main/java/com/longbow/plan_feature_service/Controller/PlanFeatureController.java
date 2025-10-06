package com.longbow.plan_feature_service.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longbow.plan_feature_service.Payload.PlanFeatureRequestDto;
import com.longbow.plan_feature_service.Payload.PlanFeatureResponseDto;
import com.longbow.plan_feature_service.ServiceInf.PlanFeatureService;

@RestController
@RequestMapping("/api/features")
public class PlanFeatureController {
	@Autowired
    private PlanFeatureService service;

    // Create a new feature
    @PostMapping
    public ResponseEntity<PlanFeatureResponseDto> createFeature(
            @Validated @RequestBody PlanFeatureRequestDto dto) {
        return ResponseEntity.ok(service.createFeature(dto));
    }

    // Get all features
    @GetMapping
    public ResponseEntity<List<PlanFeatureResponseDto>> getAllFeatures() {
        return ResponseEntity.ok(service.getAllFeatures());
    }

    // Get feature by ID
    @GetMapping("/{id}")
    public ResponseEntity<PlanFeatureResponseDto> getFeatureById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFeatureById(id));
    }

    // Update entire feature
    @PutMapping("/{id}")
    public ResponseEntity<PlanFeatureResponseDto> updateFeature(
            @PathVariable Long id,
            @Validated @RequestBody PlanFeatureRequestDto dto) {
        return ResponseEntity.ok(service.updateFeature(id, dto));
    }

    // Partial update (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<PlanFeatureResponseDto> updatePartialFeature(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(service.updatePartialFeature(id, updates));
    }

    // Delete feature
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        service.deleteFeature(id);
        return ResponseEntity.noContent().build();
    }
}

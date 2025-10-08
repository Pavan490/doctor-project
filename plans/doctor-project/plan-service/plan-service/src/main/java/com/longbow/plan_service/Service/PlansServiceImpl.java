package com.longbow.plan_service.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longbow.plan_service.DTO.PlansDTO;
import com.longbow.plan_service.Entity.Plans;
import com.longbow.plan_service.Exception.InvalidDataException;
import com.longbow.plan_service.Exception.ResourceNotFoundException;
import com.longbow.plan_service.Repository.PlansRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlansServiceImpl implements PlansService {

    @Autowired
    private PlansRepository plansRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PlansDTO createPlan(PlansDTO planDTO) {
        if (planDTO.getPrice() != null && planDTO.getPrice() < 0) {
            throw new InvalidDataException("Price cannot be negative");
        }
        if (planDTO.getDuration() != null && planDTO.getDuration() <= 0) {
            throw new InvalidDataException("Duration must be greater than 0");
        }

        // Map DTO to entity
        Plans plan = modelMapper.map(planDTO, Plans.class);

        // Set timestamps
        LocalDateTime now = LocalDateTime.now();
        plan.setCreatedAt(now);
        plan.setUpdatedAt(now);

        Plans savedPlan = plansRepository.save(plan);

        // Map entity back to DTO
        return modelMapper.map(savedPlan, PlansDTO.class);
    }

    @Override
    public List<PlansDTO> getAllPlans() {
        List<Plans> plans = plansRepository.findAll();
        if (plans.isEmpty()) {
            throw new ResourceNotFoundException("No plans available");
        }
        return plans.stream()
                .map(plan -> modelMapper.map(plan, PlansDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlansDTO getPlanById(int planId) {
        Plans plan = plansRepository.findById(planId)
                .orElseThrow(() -> new ResourceNotFoundException("Plan with ID " + planId + " not found"));
        return modelMapper.map(plan, PlansDTO.class);
    }

    @Override
    public PlansDTO updatePlan(int planId, PlansDTO planDTO) {
        Plans existingPlan = plansRepository.findById(planId)
                .orElseThrow(() -> new ResourceNotFoundException("Plan with ID " + planId + " not found"));

        if (planDTO.getPrice() != null && planDTO.getPrice() < 0) {
            throw new InvalidDataException("Price cannot be negative");
        }
        if (planDTO.getDuration() != null && planDTO.getDuration() <= 0) {
            throw new InvalidDataException("Duration must be greater than 0");
        }

        // Update fields
        existingPlan.setPlanName(planDTO.getPlanName());
        existingPlan.setPrice(planDTO.getPrice());
        existingPlan.setDuration(planDTO.getDuration());
        existingPlan.setIsActive(planDTO.getIsActive());

        // Update timestamp
        existingPlan.setUpdatedAt(LocalDateTime.now());

        Plans updatedPlan = plansRepository.save(existingPlan);

        return modelMapper.map(updatedPlan, PlansDTO.class);
    }

    @Override
    public void deletePlan(int planId) {
        if (!plansRepository.existsById(planId)) {
            throw new ResourceNotFoundException("Plan with ID " + planId + " not found");
        }
        plansRepository.deleteById(planId);
    }
    @Override
    public List<PlansDTO> getActivePlans(boolean isActive) {
        List<Plans> plans = plansRepository.findByIsActive(isActive);
        if (plans.isEmpty()) {
            throw new ResourceNotFoundException("No " + (isActive ? "active" : "inactive") + " plans found");
        }
        return plans.stream()
                .map(plan -> modelMapper.map(plan, PlansDTO.class))
                .collect(Collectors.toList());
    }

}
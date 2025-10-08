package com.longbow.plan_feature_service.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longbow.plan_feature_service.Entity.PlanFeature;
import com.longbow.plan_feature_service.Exceptions.InvalidDataException;
import com.longbow.plan_feature_service.Exceptions.ResourceNotFoundException;
import com.longbow.plan_feature_service.Payload.PlanFeatureRequestDto;
import com.longbow.plan_feature_service.Payload.PlanFeatureResponseDto;
import com.longbow.plan_feature_service.Repository.PlanFeatureRepository;
import com.longbow.plan_feature_service.ServiceInf.PlanFeatureService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanFeatureServiceImpl implements PlanFeatureService {
	@Autowired
    private PlanFeatureRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PlanFeatureResponseDto createFeature(PlanFeatureRequestDto dto) {
        PlanFeature feature = modelMapper.map(dto, PlanFeature.class);

        // Force ID to null to ensure insert
        feature.setFeatureId(null);

        feature.setCreatedAt(LocalDateTime.now());
        feature.setUpdatedAt(LocalDateTime.now());

        PlanFeature saved = repository.save(feature);
        return modelMapper.map(saved, PlanFeatureResponseDto.class);
    }

    @Override
    public PlanFeatureResponseDto getFeatureById(Long id) {
        PlanFeature feature = repository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Feature not found with id: " + id));
        return modelMapper.map(feature, PlanFeatureResponseDto.class);
    }

    @Override
    public List<PlanFeatureResponseDto> getAllFeatures() {
        return repository.findAll()
                .stream()
                .map(f -> modelMapper.map(f, PlanFeatureResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlanFeatureResponseDto updateFeature(Long id, PlanFeatureRequestDto dto) {
        PlanFeature feature = repository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Feature not found with id: " + id));

        // Update all fields
        feature.setPlanId(dto.getPlanId().intValue());
        feature.setFeatureName(dto.getFeatureName());
        feature.setFeatureCount(dto.getFeatureCount());
        feature.setIsActive(dto.getIsActive());
        feature.setUpdatedAt(LocalDateTime.now());

        return modelMapper.map(repository.save(feature), PlanFeatureResponseDto.class);
    }

    @Override
    public PlanFeatureResponseDto updatePartialFeature(Long id, Map<String, Object> updates) {
        PlanFeature feature = repository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Feature not found with id: " + id));

        // Update only provided fields
        updates.forEach((key, value) -> {
            switch (key) {
                case "planId":
                    feature.setPlanId(Long.valueOf(value.toString()).intValue());
                    break;
                case "featureName":
                    feature.setFeatureName(value.toString());
                    break;
                case "featureCount":
                    feature.setFeatureCount(Integer.valueOf(value.toString()));
                    break;
                case "isActive":
                    feature.setIsActive(Boolean.valueOf(value.toString()));
                    break;
                default:
                    throw new InvalidDataException("Invalid field: " + key);
            }
        });

        feature.setUpdatedAt(LocalDateTime.now());
        return modelMapper.map(repository.save(feature), PlanFeatureResponseDto.class);
    }

    @Override
    public void deleteFeature(Long id) {
        if (!repository.existsById(id.intValue())) {
            throw new ResourceNotFoundException("Feature not found with id: " + id);
        }
        repository.deleteById(id.intValue());
    }
}

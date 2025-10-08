package com.longbow.plan_feature_service.ServiceInf;

import java.util.List;
import java.util.Map;

import com.longbow.plan_feature_service.Payload.PlanFeatureRequestDto;
import com.longbow.plan_feature_service.Payload.PlanFeatureResponseDto;

public interface PlanFeatureService {
	PlanFeatureResponseDto createFeature(PlanFeatureRequestDto dto);

    PlanFeatureResponseDto getFeatureById(Long id);

    List<PlanFeatureResponseDto> getAllFeatures();

    PlanFeatureResponseDto updateFeature(Long id, PlanFeatureRequestDto dto);

    PlanFeatureResponseDto updatePartialFeature(Long id, Map<String, Object> updates);

    void deleteFeature(Long id);
}

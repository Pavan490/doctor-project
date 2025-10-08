package com.longbow.plan_feature_service.Payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PlanFeatureRequestDto {
	@NotNull(message = "Plan ID cannot be null")
	private Long planId;
	@NotBlank(message = "Feature name is required")
	@Size(max = 64, message = "Feature name cannot exceed 64 characters")
    private String featureName;
	@Min(value = 0, message = "Feature count must be zero or greater")
    private Integer featureCount;
	@NotNull(message = "isActive must not be null")
    private Boolean isActive;
}

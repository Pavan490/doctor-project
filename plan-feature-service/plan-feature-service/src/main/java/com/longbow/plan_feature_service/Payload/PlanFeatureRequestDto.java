package com.longbow.plan_feature_service.Payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


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
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public Integer getFeatureCount() {
		return featureCount;
	}
	public void setFeatureCount(Integer featureCount) {
		this.featureCount = featureCount;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public PlanFeatureRequestDto(@NotNull(message = "Plan ID cannot be null") Long planId,
			@NotBlank(message = "Feature name is required") @Size(max = 64, message = "Feature name cannot exceed 64 characters") String featureName,
			@Min(value = 0, message = "Feature count must be zero or greater") Integer featureCount,
			@NotNull(message = "isActive must not be null") Boolean isActive) {
		super();
		this.planId = planId;
		this.featureName = featureName;
		this.featureCount = featureCount;
		this.isActive = isActive;
	}
	
}

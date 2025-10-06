package com.longbow.plan_feature_service.Payload;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlanFeatureResponseDto {
	private Long featureId;
	@NotNull(message = "Plan ID cannot be null")
    private Long planId;
	@NotBlank(message = "Feature name is required")
	@Size(max = 64, message = "Feature name cannot exceed 64 characters")
    private String featureName;
	@Min(value = 0, message = "Feature count must be zero or greater")
    private Integer featureCount;
	@NotNull(message = "isActive must not be null")
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
	public Long getFeatureId() {
		return featureId;
	}
	public void setFeatureId(Long featureId) {
		this.featureId = featureId;
	}
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
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public PlanFeatureResponseDto(Long featureId, @NotNull(message = "Plan ID cannot be null") Long planId,
			@NotBlank(message = "Feature name is required") @Size(max = 64, message = "Feature name cannot exceed 64 characters") String featureName,
			@Min(value = 0, message = "Feature count must be zero or greater") Integer featureCount,
			@NotNull(message = "isActive must not be null") Boolean isActive, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.featureId = featureId;
		this.planId = planId;
		this.featureName = featureName;
		this.featureCount = featureCount;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public PlanFeatureResponseDto() {
		super();
	}
    
    
}

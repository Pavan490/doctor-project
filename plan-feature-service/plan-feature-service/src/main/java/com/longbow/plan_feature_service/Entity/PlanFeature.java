package com.longbow.plan_feature_service.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLAN_FEATURES")

public class PlanFeature {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "FEATURE_ID")
	    private Integer featureId;

	    
	    @Column(name = "PLAN_ID", nullable = false)
	    private Integer planId;

	     
	    @Column(name = "FEATURE_NAME", length = 64)
	    private String featureName;

	     
	    @Column(name = "FEATURE_COUNT")
	    private Integer featureCount;

	     
	    @Column(name = "IS_ACTIVE")
	    private Boolean isActive;

	    @Column(name = "CREATED_AT")
	    private LocalDateTime createdAt;

	    @Column(name = "UPDATED_AT")
	    private LocalDateTime updatedAt;

		public Integer getFeatureId() {
			return featureId;
		}

		public void setFeatureId(Integer featureId) {
			this.featureId = featureId;
		}

		public Integer getPlanId() {
			return planId;
		}

		public void setPlanId(Integer planId) {
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

		public PlanFeature(Integer featureId, Integer planId, String featureName, Integer featureCount,
				Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
			super();
			this.featureId = featureId;
			this.planId = planId;
			this.featureName = featureName;
			this.featureCount = featureCount;
			this.isActive = isActive;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}

}

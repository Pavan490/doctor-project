package com.longbow.plan_feature_service.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PLAN_FEATURES")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}

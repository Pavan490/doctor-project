package com.longbow.coupon_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COUPONS")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COUPON_ID")
    private Integer couponId;

    @Column(name = "PLAN_ID")
    @Positive(message = "Plan ID must be a positive number")
    private Integer planId;

    @Column(name = "COUPON_NAME", length = 64, nullable = false)
    @NotBlank(message = "Coupon name must not be blank")
    @Size(max = 64, message = "Coupon name must be at most 64 characters")
    private String couponName;

    @Column(name = "PERCENTAGE", nullable = false)
    @Min(value = 0, message = "Percentage must be at least 0")
    @Max(value = 100, message = "Percentage cannot exceed 100")
    private Integer percentage;

    @Column(name = "ALL_PLANS", nullable = false)
    private Boolean allPlans = false;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive = true;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt = LocalDateTime.now();
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Constructors
    public Coupon() {
    }

    public Coupon(Integer planId, String couponName, Integer percentage, Boolean allPlans, Boolean isActive) {
        this.planId = planId;
        this.couponName = couponName;
        this.percentage = percentage;
        this.allPlans = allPlans;
        this.isActive = isActive;
    }

    // Getters and Setters
    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Boolean getAllPlans() {
        return allPlans;
    }

    public void setAllPlans(Boolean allPlans) {
        this.allPlans = allPlans;
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

    // Optional: toString for logging
    @Override
    public String toString() {
        return "Coupon{" +
                "couponId=" + couponId +
                ", planId=" + planId +
                ", couponName='" + couponName + '\'' +
                ", percentage=" + percentage +
                ", allPlans=" + allPlans +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}



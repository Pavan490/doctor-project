package com.longbow.coupon_service.service;
import com.longbow.coupon_service.entity.Coupon;
import java.util.List;

public interface CouponService {

    // Add a single coupon
    Coupon addCoupon(Coupon coupon);

    // Add multiple coupons
    List<Coupon> addCoupons(List<Coupon> coupons);

    // Get all coupons
    List<Coupon> getAllCoupons();

    // Get a single coupon by ID
    Coupon getCouponById(Integer couponId);

    // Update coupon partially (PATCH)
    Coupon updateCoupon(Integer couponId, Coupon coupon);

    // Remove coupon by ID (soft delete or hard delete)
    void deleteCoupon(Integer couponId);
}


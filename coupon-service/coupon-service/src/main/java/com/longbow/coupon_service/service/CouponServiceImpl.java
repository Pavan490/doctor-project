package com.longbow.coupon_service.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longbow.coupon_service.entity.Coupon;
import com.longbow.coupon_service.repository.CouponRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public Coupon addCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public List<Coupon> addCoupons(List<Coupon> coupons) {
        return couponRepository.saveAll(coupons);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon getCouponById(Integer couponId) {
        Optional<Coupon> optional = couponRepository.findById(couponId);
        return optional.orElseThrow(() -> new RuntimeException("Coupon not found with ID: " + couponId));
    }

    @Override
    public Coupon updateCoupon(Integer couponId, Coupon coupon) {
        Coupon existing = getCouponById(couponId);

        // Partial update (PATCH-like)
        if (coupon.getPlanId() != null) existing.setPlanId(coupon.getPlanId());
        if (coupon.getCouponName() != null) existing.setCouponName(coupon.getCouponName());
        if (coupon.getPercentage() != null) existing.setPercentage(coupon.getPercentage());
        if (coupon.getAllPlans() != null) existing.setAllPlans(coupon.getAllPlans());
        if (coupon.getIsActive() != null) existing.setIsActive(coupon.getIsActive());

        return couponRepository.save(existing);
    }

    @Override
    public void deleteCoupon(Integer couponId) {
        Coupon existing = getCouponById(couponId);
        couponRepository.delete(existing);
    }
}



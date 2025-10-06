package com.longbow.coupon_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.longbow.coupon_service.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}

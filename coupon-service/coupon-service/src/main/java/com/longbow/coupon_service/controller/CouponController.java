package com.longbow.coupon_service.controller;

import com.longbow.coupon_service.entity.Coupon;
import com.longbow.coupon_service.service.CouponService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    // ✅ Add a single coupon
    @PostMapping
    public ResponseEntity<Coupon> addCoupon(@Valid @RequestBody Coupon coupon) {
        Coupon created = couponService.addCoupon(coupon);
        return ResponseEntity.status(201).body(created);
    }

    // ✅ Add multiple coupons
    @PostMapping("/batch")
    public ResponseEntity<List<Coupon>> addCoupons(@Valid @RequestBody List<Coupon> coupons) {
        List<Coupon> created = couponService.addCoupons(coupons);
        return ResponseEntity.status(201).body(created);
    }

    // ✅ Get all coupons
    @GetMapping
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        List<Coupon> coupons = couponService.getAllCoupons();
        return ResponseEntity.ok(coupons);
    }

    // ✅ Get coupon by ID
    @GetMapping("/{id}")
    public ResponseEntity<Coupon> getCouponById(@PathVariable("id") Integer id) {
        Coupon coupon = couponService.getCouponById(id);
        return ResponseEntity.ok(coupon);
    }

    // ✅ Patch (update partially using entity itself)
    @PatchMapping("/{id}")
    public ResponseEntity<Coupon> patchCoupon(
            @PathVariable("id") Integer id,
            @RequestBody Coupon coupon) {  // No @Valid here because fields may be null for partial update
        Coupon updated = couponService.updateCoupon(id, coupon);
        return ResponseEntity.ok(updated);
    }

    // ✅ Delete coupon by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable("id") Integer id) {
        couponService.deleteCoupon(id);
        return ResponseEntity.noContent().build();
    }
}

package com.longbow.subscription_service.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
@Entity
@Table(name = "`SUBSCRIPTION`")

public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBSCRIPTION_ID")
    private Integer SUBSCRIPTION_ID;

    @Column(name = "DOCTOR_ID")
    private Integer DOCTOR_ID;

    @Column(name = "PLAN_ID")
    private Integer PLAN_ID;

    @Column(name = "PLAN_PRICEE")
    private Integer PLAN_PRICEE;

    @Column(name = "DISCOUNT_AMOUNT")
    private Integer DISCOUNT_AMOUNT;

    @Column(name = "COUPON_ID")
    private Integer COUPON_ID;

    @Column(name = "PLAN_START_DATE")
    private Date PLAN_START_DATE;

    @Column(name = "PLAN_END_DATE")
    private Date PLAN_END_DATE;

    @Column(name = "INVOICE")
    private String INVOICE;

    @Column(name = "IS_ACTIVE")
    private Boolean IS_ACTIVE;

    @Column(name = "CREATED_AT")
    private Date CREATED_AT;

    @Column(name = "UPDATED_AT")
    private Date UPDATED_AT;

    public Integer getSUBSCRIPTION_ID() {
        return SUBSCRIPTION_ID;
    }

    public void setSUBSCRIPTION_ID(Integer sUBSCRIPTION_ID) {
        SUBSCRIPTION_ID = sUBSCRIPTION_ID;
    }

    public Integer getDOCTOR_ID() {
        return DOCTOR_ID;
    }

    public void setDOCTOR_ID(Integer dOCTOR_ID) {
        DOCTOR_ID = dOCTOR_ID;
    }

    public Integer getPLAN_ID() {
        return PLAN_ID;
    }

    public void setPLAN_ID(Integer pLAN_ID) {
        PLAN_ID = pLAN_ID;
    }

    public Integer getPLAN_PRICEE() {
        return PLAN_PRICEE;
    }

    public void setPLAN_PRICEE(Integer pLAN_PRICEE) {
        PLAN_PRICEE = pLAN_PRICEE;
    }

    public Integer getDISCOUNT_AMOUNT() {
        return DISCOUNT_AMOUNT;
    }

    public void setDISCOUNT_AMOUNT(Integer dISCOUNT_AMOUNT) {
        DISCOUNT_AMOUNT = dISCOUNT_AMOUNT;
    }

    public Integer getCOUPON_ID() {
        return COUPON_ID;
    }

    public void setCOUPON_ID(Integer cOUPON_ID) {
        COUPON_ID = cOUPON_ID;
    }

    public Date getPLAN_START_DATE() {
        return PLAN_START_DATE;
    }

    public void setPLAN_START_DATE(Date pLAN_START_DATE) {
        PLAN_START_DATE = pLAN_START_DATE;
    }

    public Date getPLAN_END_DATE() {
        return PLAN_END_DATE;
    }

    public void setPLAN_END_DATE(Date pLAN_END_DATE) {
        PLAN_END_DATE = pLAN_END_DATE;
    }

    public String getINVOICE() {
        return INVOICE;
    }

    public void setINVOICE(String iNVOICE) {
        INVOICE = iNVOICE;
    }

    public Boolean getIS_ACTIVE() {
        return IS_ACTIVE;
    }

    public void setIS_ACTIVE(Boolean iS_ACTIVE) {
        IS_ACTIVE = iS_ACTIVE;
    }

    public Date getCREATED_AT() {
        return CREATED_AT;
    }

    public void setCREATED_AT(Date cREATED_AT) {
        CREATED_AT = cREATED_AT;
    }

    public Date getUPDATED_AT() {
        return UPDATED_AT;
    }

    public void setUPDATED_AT(Date uPDATED_AT) {
        UPDATED_AT = uPDATED_AT;
    }
}

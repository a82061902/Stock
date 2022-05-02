package com.csw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Purchase {
    private String orderId;
    private String goodsId;
    private String name;
    private Integer count;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date inTime;
    private String supplierName;

    public Purchase(String orderId, String goodsId, String name, Integer count, Date inTime, String supplierName) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.name = name;
        this.count = count;
        this.inTime = inTime;
        this.supplierName = supplierName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public Date getInTime() {
        return inTime;
    }


    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}

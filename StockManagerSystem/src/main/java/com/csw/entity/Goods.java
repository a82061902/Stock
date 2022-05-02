package com.csw.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Goods {
    private String goodsId;
    private String name;
    private Integer count;
    private String supplierName;


    public Goods(String goodsId, String name, Integer count, String supplierName) {
        this.goodsId = goodsId;
        this.name = name;
        this.count = count;
        this.supplierName = supplierName;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

}

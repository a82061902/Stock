package com.csw.entity;

public class Tmp {
    private String goodsId;
    private Integer count;
    private String supplierName;

    public Tmp() {
    }

    public Tmp(String goodsId, Integer count, String supplierName) {
        this.goodsId = goodsId;
        this.count = count;
        this.supplierName = supplierName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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

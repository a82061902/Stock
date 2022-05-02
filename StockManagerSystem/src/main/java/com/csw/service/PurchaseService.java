package com.csw.service;

import com.csw.common.vo.PurchaseQuery;
import com.csw.entity.Purchase;

import java.util.List;

public interface PurchaseService {
    Long getCounts();

    Long getCountsBySum();

    List<Purchase> getPurchasesByParam(PurchaseQuery param);

    void addPurchase(Purchase purchase);

    void deletePurchaseByOrderIds(String[] orderIds);
}

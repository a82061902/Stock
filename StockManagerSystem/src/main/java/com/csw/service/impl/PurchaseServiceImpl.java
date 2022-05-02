package com.csw.service.impl;

import com.csw.common.vo.PurchaseQuery;
import com.csw.entity.Purchase;
import com.csw.mapper.PurchaseMapper;
import com.csw.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchaseMapper purchaseMapper;

    @Override
    public Long getCounts() {
        return purchaseMapper.getCounts();
    }

    @Override
    public Long getCountsBySum() {
        return purchaseMapper.getCountsBySum();
    }

    @Override
    public List<Purchase> getPurchasesByParam(PurchaseQuery param) {
        return purchaseMapper.getPurchasesByParam(param);
    }

    @Override
    public void addPurchase(Purchase purchase) {
         purchaseMapper.addPurchase(purchase);
    }

    @Override
    public void deletePurchaseByOrderIds(String[] orderIds) {
        purchaseMapper.deletePurchaseByOrderIds(orderIds);
    }
}

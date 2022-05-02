package com.csw.mapper;

import com.csw.common.vo.PurchaseQuery;
import com.csw.entity.Purchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseMapper{
    Long getCounts();

    Long getCountsBySum();

    List<Purchase> getPurchasesByParam(PurchaseQuery param);

    void addPurchase(Purchase purchase);

    void deletePurchaseByOrderIds(String[] orderIds);
}

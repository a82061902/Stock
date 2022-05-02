package com.csw.service;

import com.csw.entity.DateTmp;

import java.util.List;

public interface DateTmpService {
    void deleteAll();

    void insertPurchase();

    void insertShipment();

    List<DateTmp> getAllDateTmp();

    List<DateTmp> getDateTmpByYear(String year);
}

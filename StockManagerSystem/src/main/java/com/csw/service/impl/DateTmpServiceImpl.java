package com.csw.service.impl;

import com.csw.entity.DateTmp;
import com.csw.mapper.DateTmpMapper;
import com.csw.service.DateTmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateTmpServiceImpl implements DateTmpService {
    @Autowired
    DateTmpMapper dateTmpMapper;

    @Override
    public void insertPurchase() {
        dateTmpMapper.insertPurchase();
    }

    @Override
    public void insertShipment() {
        dateTmpMapper.insertShipment();
    }

    @Override
    public List<DateTmp> getAllDateTmp() {
        return dateTmpMapper.getAllDateTmp();
    }

    @Override
    public void deleteAll() {
        dateTmpMapper.deleteAll();
    }

    @Override
    public List<DateTmp> getDateTmpByYear(String year) {
        return dateTmpMapper.getDateTmpByYear(year);
    }
}

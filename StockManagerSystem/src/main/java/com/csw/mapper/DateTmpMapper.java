package com.csw.mapper;

import com.csw.entity.DateTmp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DateTmpMapper {
    void deleteAll();

    void insertPurchase();

    void insertShipment();

    List<DateTmp> getAllDateTmp();

    List<DateTmp> getDateTmpByYear(String year);
}

package com.csw.mapper;

import com.csw.entity.Tmp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TmpMapper {
    void addTmp(Tmp tmp);
    void delAllTmp();
}

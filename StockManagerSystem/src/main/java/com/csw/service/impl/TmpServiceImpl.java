package com.csw.service.impl;

import com.csw.entity.Tmp;
import com.csw.mapper.TmpMapper;
import com.csw.service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TmpServiceImpl implements TmpService {
    @Autowired
    TmpMapper tmpMapper;

    @Override
    public void addTmp(Tmp tmp) {
        tmpMapper.addTmp(tmp);
    }

    @Override
    public void delAllTmp() {
        tmpMapper.delAllTmp();
    }
}

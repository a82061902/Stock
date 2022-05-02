package com.csw.service.impl;

import com.csw.common.vo.GoodsQuery;
import com.csw.entity.Goods;
import com.csw.entity.NameAndCount;
import com.csw.mapper.GoodsMapper;
import com.csw.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Long getCounts() {
        return goodsMapper.getCounts();
    }

    @Override
    public Long getCountsBySum() {
       return goodsMapper.getCountsBySum();
    }

    @Override
    public List<NameAndCount> getGoodsCountsGroupByName() {
        return goodsMapper.getGoodsCountsGroupByName();
    }

    @Override
    public void addGoods(Goods goods) {
        goodsMapper.addGoods(goods);
    }

    @Override
    public void updateGoodsByMinus(){
        goodsMapper.updateGoodsByMinus();
    }

    @Override
    public void updateGoodsByPlus() {
        goodsMapper.updateGoodsByPlus();
    }

    @Override
    public List<Goods> getGoodsByParam(GoodsQuery param) {
        return goodsMapper.getGoodsByParam(param);
    }

    @Override
    public Goods getGoodsByIdAndSupplierName(String goodsId, String supplierName) {
        return goodsMapper.getGoodsByIdAndSupplierName(goodsId,supplierName);
    }

    @Override
    public void deleteGoodsByIds(String[] ids) {
        goodsMapper.deleteGoodsByIds(ids);
    }

    @Override
    public void editGoods(String goodsId) {
        goodsMapper.editGoods(goodsId);
    }

}

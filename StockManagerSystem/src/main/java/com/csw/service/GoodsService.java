package com.csw.service;

import com.csw.common.vo.GoodsQuery;
import com.csw.entity.Goods;
import com.csw.entity.NameAndCount;

import java.util.List;

public interface GoodsService {
    Long getCounts();

    Long getCountsBySum();

    List<NameAndCount> getGoodsCountsGroupByName();

    void addGoods(Goods goods);

    void updateGoodsByMinus();

    void updateGoodsByPlus();

    List<Goods> getGoodsByParam(GoodsQuery param);

    Goods getGoodsByIdAndSupplierName(String id ,String supplierName);

    void deleteGoodsByIds(String[] ids);

    void editGoods(String goodsId);

}

package com.csw.mapper;

import com.csw.common.vo.GoodsQuery;
import com.csw.entity.Goods;
import com.csw.entity.NameAndCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    Long getCounts();

    Long getCountsBySum();

    List<NameAndCount> getGoodsCountsGroupByName();

    void addGoods(Goods goods);

    void updateGoodsByMinus();

    void updateGoodsByPlus();

    List<Goods> getGoodsByParam(GoodsQuery param);

    Goods getGoodsByIdAndSupplierName(String goodsId ,String supplierName);

    void deleteGoodsByIds(String[] ids);

    void editGoods(String goodsId);

}

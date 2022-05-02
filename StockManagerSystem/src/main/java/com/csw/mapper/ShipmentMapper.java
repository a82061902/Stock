package com.csw.mapper;

import com.csw.common.vo.ShipmentQuery;
import com.csw.entity.Purchase;
import com.csw.entity.Shipment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShipmentMapper {
    List<Shipment> getShipmentsByParam(ShipmentQuery param);

    Long getCounts();

    Long getCountsBySum();

    void deleteShipmentByOrderIds(String[] orderIds);

    void addShipment(Shipment shipment);
}

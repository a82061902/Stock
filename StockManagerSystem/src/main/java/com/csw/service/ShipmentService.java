package com.csw.service;

import com.csw.common.vo.ShipmentQuery;
import com.csw.entity.Purchase;
import com.csw.entity.Shipment;

import java.util.List;

public interface ShipmentService {
    List<Shipment> getShipmentsByParam(ShipmentQuery param);

    Long getCounts();

    Long getCountsBySum();

    void deleteShipmentByOrderIds(String[] orderIds);

    void addShipment(Shipment shipment);
}

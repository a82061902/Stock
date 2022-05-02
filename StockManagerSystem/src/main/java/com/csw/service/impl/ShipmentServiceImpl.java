package com.csw.service.impl;

import com.csw.common.vo.ShipmentQuery;
import com.csw.entity.Shipment;
import com.csw.mapper.ShipmentMapper;
import com.csw.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService{
    @Autowired
    ShipmentMapper shipmentMapper;

    @Override
    public List<Shipment> getShipmentsByParam(ShipmentQuery param) {
        return shipmentMapper.getShipmentsByParam(param);
    }

    @Override
    public Long getCounts() {
        return shipmentMapper.getCounts();
    }

    @Override
    public Long getCountsBySum() {
        return shipmentMapper.getCountsBySum();
    }

    @Override
    public void deleteShipmentByOrderIds(String[] orderIds) {
        shipmentMapper.deleteShipmentByOrderIds(orderIds);
    }

    @Override
    public void addShipment(Shipment shipment) {
        shipmentMapper.addShipment(shipment);
    }
}

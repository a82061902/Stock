package com.csw.controller;

import com.csw.common.vo.Result;
import com.csw.common.vo.ShipmentQuery;
import com.csw.entity.Shipment;
import com.csw.service.impl.ShipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {
    @Autowired
    ShipmentServiceImpl shipmentService;

    @RequestMapping("")
    public String toShipmentUI(){
        return "goods/shipmentUI";
    }


    @RequestMapping("/getShipments")
    @ResponseBody
    public Result<Object> getShipments(ShipmentQuery param){
        List<Shipment> shipments =shipmentService.getShipmentsByParam(param);
        Long counts=shipmentService.getCounts();
        return Result.success(shipments,counts);
    }

    @RequestMapping("/deleteShipmentByOrderIds/{orderIds}")
    @ResponseBody
    public Result<Object> deleteShipmentByOrderIds(@PathVariable("orderIds")String[] orderIds){
        shipmentService.deleteShipmentByOrderIds(orderIds);
        return Result.success("删除信息成功");
    }



}

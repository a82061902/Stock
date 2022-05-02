package com.csw.controller;

import com.csw.common.vo.PurchaseQuery;
import com.csw.common.vo.Result;
import com.csw.entity.Purchase;
import com.csw.pojo.OrderMaker;
import com.csw.service.impl.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    PurchaseServiceImpl purchaseService;

    @RequestMapping("")
    public String toPurchaseUI(){
        return "goods/purchaseUI";
    }

    @RequestMapping("/getPurchases" )
    @ResponseBody
    public Result<Object> getPurchases(PurchaseQuery param){
        List<Purchase> purchases =purchaseService.getPurchasesByParam(param);
        Long counts=purchaseService.getCounts();
        return Result.success(purchases,counts);
    }


    @RequestMapping("/deletePurchaseByOrderIds/{orderIds}")
    @ResponseBody
    public Result<Object> deleteGoodsByIds(@PathVariable("orderIds")String[] orderIds){
        purchaseService.deletePurchaseByOrderIds(orderIds);
        return Result.success("删除信息成功");
    }

}

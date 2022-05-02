package com.csw.controller;

import com.csw.common.vo.GoodsQuery;
import com.csw.entity.*;
import com.csw.pojo.OrderMaker;
import com.csw.service.impl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.csw.common.vo.Result;


import java.util.List;

@RequestMapping("/goods")
@Controller
public class GoodsController {

    @Autowired
    GoodsServiceImpl goodsService;
    @Autowired
    SupplierServiceImpl supplierService;
    @Autowired
    PurchaseServiceImpl purchaseService;
    @Autowired
    ShipmentServiceImpl shipmentService;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    TmpServiceImpl tmpService;

    //先跳转到页面，加载页面后才能接收json数据并渲染表格
    @RequestMapping("")
    public String toGoodsList(){
        return "goods/goodsList";
    }

    //返回layui要求的json数据格式result类给goodsList页面
    @RequestMapping("/getGoods")
    @ResponseBody
    public Result<Object> getGoods(GoodsQuery param){
        List<Goods> lists=goodsService.getGoodsByParam(param);
        Long counts=goodsService.getCounts();
        return Result.success(lists,counts);
    }

    //货物入库并添加到purchase表
    @RequestMapping("/addGoods")
    @ResponseBody
    public Result<Object> addGoods(Purchase purchase)
    {
        tmpService.delAllTmp();//清空临时表
        purchase.setOrderId(OrderMaker.getOrderNo());//设置订单号
        purchaseService.addPurchase(purchase);
        tmpService.addTmp(new Tmp(purchase.getGoodsId(), purchase.getCount(), purchase.getSupplierName()));//把入库数据传入临时表

        //判断库存表中有无相同货物 无则增加有则更新
        if(goodsService.getGoodsByIdAndSupplierName(purchase.getGoodsId(),purchase.getSupplierName())==null)
            goodsService.addGoods(new Goods(purchase.getGoodsId(),purchase.getName(),purchase.getCount(),purchase.getSupplierName()));
        else
            goodsService.updateGoodsByPlus(); //货物入库
        return Result.success();
    }

    //货物出库并添加到shipment表
    @RequestMapping("/editGoods")
    @ResponseBody
    @Transactional //开启事务
    public Result<Object> editGoods(Shipment shipment, String supplierName){
        tmpService.delAllTmp();
        shipment.setOrderId(OrderMaker.getOrderNo());
        shipmentService.addShipment(shipment);
        tmpService.addTmp(new Tmp(shipment.getGoodsId(), shipment.getCount(), supplierName));

        //判断库存是否为零
        Goods goods=goodsService.getGoodsByIdAndSupplierName(shipment.getGoodsId(),supplierName);
        if(goods.getCount()==0||goods.getCount()-shipment.getCount()<0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //事务回滚
            return Result.fail("库存不足");
        }
        else {
            goodsService.updateGoodsByMinus();
            return Result.success();
        }
    }

    //根据货物编号删除记录
    @RequestMapping("/deleteGoodsByIds/{ids}")
    @ResponseBody
    public Result<Object> deleteGoodsByIds(@PathVariable("ids")String[] ids){
        goodsService.deleteGoodsByIds(ids);
        return Result.success("删除信息成功");
    }


    //转到货物入库页面接收下拉框需要的公司名的数据
    @RequestMapping("/addGoodsUI")
    public String addGoodsUI(Model model)
    {
        //供货商名称传递给选择框
        List<Supplier> supplierList=supplierService.getAllSupplier();
        model.addAttribute("supplierList",supplierList);
        return "goods/addGoodsUI";
    }



    //可能出现相同货物不同供应商的情况，需要定义Goods集合并返回验证条件supplierName并传递给editGoodsUI页面
    @RequestMapping("/{goodsId}/{supplierName}")
    public String getGoodsByIdAndSupplierName(@PathVariable("goodsId")String goodsId, @PathVariable("supplierName")String supplierName, Model model){
        Goods goods=goodsService.getGoodsByIdAndSupplierName(goodsId ,supplierName);

        //将查询到的数据传递给edit页面用于数据回显
        model.addAttribute("goods",goods);
        model.addAttribute("customerList",customerService.getAllCustomer());
        model.addAttribute("supplierName",supplierName);
        model.addAttribute("supplierList",supplierService.getAllSupplier());

        return "goods/editGoodsUI";
    }

}

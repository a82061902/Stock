package com.csw.controller;

import com.csw.common.vo.YearAndMonth;
import com.csw.entity.DateTmp;
import com.csw.entity.NameAndCount;
import com.csw.pojo.YearAndMonthUtils;
import com.csw.service.DateTmpService;
import com.csw.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/charts")
public class ChartsController {
    @Autowired
    DateTmpService dateTmpService;
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/purchase")
    public String toPurchaseCharts(Model model){
        //datetmp表统计进货数据初始化操作
        dateTmpService.deleteAll();
        dateTmpService.insertPurchase();

        //定义数组与集合
        YearAndMonth[] yearAndMonths=new YearAndMonth[4];
        for(int i=0;i<4;i++)yearAndMonths[i]=new YearAndMonth(); //需要实例化调用其构造函数
        Integer[] years=new Integer[4];
        List<DateTmp> dateTmpList=dateTmpService.getAllDateTmp();

        //初始化：获取系统时间近四年年份与月份数据置为0
        years[0]= Calendar.getInstance().get(Calendar.YEAR);
        for(int i=1;i<4;i++) years[i]=years[0]-i;
        for(int i=0;i<4;i++){
            yearAndMonths[i]=YearAndMonthUtils.monthInit(yearAndMonths[i]);
            yearAndMonths[i].setYear(years[i]);
        }

        //检索dateTmpList中的数据
        for(DateTmp dateTmp:dateTmpList){
            for(int i=0;i<4;i++){
                if(dateTmp.getYear().equals(yearAndMonths[i].getYear())){ //当数值在-128 ~ 127之间，使用==的话是没有问题的，但当超过这个范围后，Integer的比较就是对象之间的比较
                    switch (dateTmp.getMonth())
                    {
                        case "1":yearAndMonths[i].setJanuary(dateTmp.getCount());break;
                        case "2":yearAndMonths[i].setFebruary(dateTmp.getCount());break;
                        case "3":yearAndMonths[i].setMarch(dateTmp.getCount());break;
                        case "4":yearAndMonths[i].setApril(dateTmp.getCount());break;
                        case "5":yearAndMonths[i].setMay(dateTmp.getCount());break;
                        case "6":yearAndMonths[i].setJune(dateTmp.getCount());break;
                        case "7":yearAndMonths[i].setJuly(dateTmp.getCount());break;
                        case "8":yearAndMonths[i].setAugust(dateTmp.getCount());break;
                        case "9":yearAndMonths[i].setSeptember(dateTmp.getCount());break;
                        case "10":yearAndMonths[i].setOctober(dateTmp.getCount());break;
                        case "11":yearAndMonths[i].setNovember(dateTmp.getCount());break;
                        case "12":yearAndMonths[i].setDecember(dateTmp.getCount());break;
                    }
                }
            }

        }

        model.addAttribute("year0",yearAndMonths[0]);
        model.addAttribute("year1",yearAndMonths[1]);
        model.addAttribute("year2",yearAndMonths[2]);
        model.addAttribute("year3",yearAndMonths[3]);

        return "charts/charts";
    }

    @RequestMapping("/shipment")
    public String toShipmentCharts(Model model){
        //datetmp表统计进货数据初始化操作
        dateTmpService.deleteAll();
        dateTmpService.insertShipment();

        //定义数组与集合
        YearAndMonth[] yearAndMonths=new YearAndMonth[4];
        for(int i=0;i<4;i++)yearAndMonths[i]=new YearAndMonth(); //需要实例化调用其构造函数
        Integer[] years=new Integer[4];
        List<DateTmp> dateTmpList=dateTmpService.getAllDateTmp();

        //初始化：获取系统时间近四年年份与月份数据置为0
        years[0]= Calendar.getInstance().get(Calendar.YEAR);
        for(int i=1;i<4;i++) years[i]=years[0]-i;
        for(int i=0;i<4;i++){
            yearAndMonths[i]=YearAndMonthUtils.monthInit(yearAndMonths[i]);
            yearAndMonths[i].setYear(years[i]);
        }

        //检索dateTmpList中的数据
        for(DateTmp dateTmp:dateTmpList){
            for(int i=0;i<4;i++){
                if(dateTmp.getYear().equals(yearAndMonths[i].getYear())){ //当数值在-128 ~ 127之间，使用==的话是没有问题的，但当超过这个范围后，Integer的比较就是对象之间的比较
                    switch (dateTmp.getMonth())
                    {
                        case "1":yearAndMonths[i].setJanuary(dateTmp.getCount());break;
                        case "2":yearAndMonths[i].setFebruary(dateTmp.getCount());break;
                        case "3":yearAndMonths[i].setMarch(dateTmp.getCount());break;
                        case "4":yearAndMonths[i].setApril(dateTmp.getCount());break;
                        case "5":yearAndMonths[i].setMay(dateTmp.getCount());break;
                        case "6":yearAndMonths[i].setJune(dateTmp.getCount());break;
                        case "7":yearAndMonths[i].setJuly(dateTmp.getCount());break;
                        case "8":yearAndMonths[i].setAugust(dateTmp.getCount());break;
                        case "9":yearAndMonths[i].setSeptember(dateTmp.getCount());break;
                        case "10":yearAndMonths[i].setOctober(dateTmp.getCount());break;
                        case "11":yearAndMonths[i].setNovember(dateTmp.getCount());break;
                        case "12":yearAndMonths[i].setDecember(dateTmp.getCount());break;
                    }
                }
            }

        }

        model.addAttribute("year0",yearAndMonths[0]);
        model.addAttribute("year1",yearAndMonths[1]);
        model.addAttribute("year2",yearAndMonths[2]);
        model.addAttribute("year3",yearAndMonths[3]);

        return "charts/charts";
    }

    @RequestMapping("/index")
    @ResponseBody
    public List<NameAndCount> toIndex(Model model){
        List<NameAndCount> nameAndCounts =goodsService.getGoodsCountsGroupByName();
        return nameAndCounts;
    }
}

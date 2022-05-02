package com.csw.common;

import com.csw.mapper.MyUserDetailsServiceMapper;
import com.csw.service.impl.GoodsServiceImpl;
import com.csw.service.impl.PurchaseServiceImpl;
import com.csw.service.impl.ShipmentServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class MyController {
    @Autowired
    GoodsServiceImpl goodsService;
    @Autowired
    PurchaseServiceImpl purchaseService;
    @Autowired
    ShipmentServiceImpl shipmentService;


    @RequestMapping({"/index.html", "/"})
    public String toIndex(HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        return "index";
    }

    @RequestMapping("welcome.html")
    public String toWelcome1(Model model) {
        //数据统计
        Long goodsCount = goodsService.getCountsBySum();
        Long purchaseCount = purchaseService.getCountsBySum();
        Long shipmentCount = shipmentService.getCountsBySum();
        Long orderCount = purchaseCount + shipmentCount;

        model.addAttribute("goodsCount", goodsCount);
        model.addAttribute("purchaseCount", purchaseCount);
        model.addAttribute("shipmentCount", shipmentCount);
        model.addAttribute("orderCount", orderCount);

        return "goods/welcome";
    }

    @RequestMapping("/loginUI")
    public String toLoginUI(@RequestParam(value = "error",required = false)String error, Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("enabled")=="true")return "login/loginUI";
        if(Objects.equals(error, "true"))model.addAttribute("error",true);
        return "login/loginUI";
    }

    //登录成功跳转 获得用户名到首页
/*    @RequestMapping("/loginSuccessTo")
    public String loginSuccessTo(Model model){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username",username);
        return "index";
    }*/

    //SprErrorPage中配置403跳转
    @RequestMapping("/403")
    public String show403(){
        return "error/403";
    }

/*    @RequestMapping("/loginUI/{error}")
    private String loginFailure(@PathVariable("error") Boolean error, Model model){
        model.addAttribute("error",error);
        return "login/loginUI";
    }*/

}



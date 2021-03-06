package com.csw.controller;

import com.csw.common.vo.CustomerQuery;
import com.csw.common.vo.Result;
import com.csw.common.vo.SupplierQuery;
import com.csw.entity.Customer;
import com.csw.entity.Supplier;
import com.csw.service.impl.CustomerServiceImpl;
import com.csw.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/info")
public class InfoController {
    @Autowired
    SupplierServiceImpl supplierService;
    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping("/supplier")
    public String toSupplierList(){
        return "info/supplierList";
    }

    @RequestMapping("/getSupplier")
    @ResponseBody
    public Result<Object> getSupplier(SupplierQuery param){
        List<Supplier> suppliers = supplierService.getSupplierByParam(param);
        Long counts= supplierService.getCounts();
        return Result.success(suppliers,counts);
    }

    @RequestMapping("/addSupplier")
    @ResponseBody
    public Result<Object> addSupplier(Supplier supplier){
        supplierService.addSupplier(supplier);
        return Result.success();
    }

    @RequestMapping("/addSupplierUI")
    public String addSupplierUI(){
        return "info/addSupplierUI";
    }

    @RequestMapping("/deleteSupplierBySupplierNames/{supplierNames}")
    @ResponseBody
    public Result<Object> deleteSupplierBySupplierName(@PathVariable("supplierNames")String[] supplierNames){
        supplierService.deleteSupplierBySupplierNames(supplierNames);
        return Result.success();
    }

    @RequestMapping("/supplier/{supplierName}/{supplierPhone}/{supplierEmail}/{supplierAddress}")
    public String getSupplierToUpdate(@PathVariable("supplierName")String supplierName, @PathVariable("supplierPhone")String supplierPhone,
                                      @PathVariable("supplierEmail")String supplierEmail, @PathVariable("supplierAddress")String supplierAddress, Model model)
    {
        //oldSupplierName????????????update????????????????????????????????????????????????????????????????????????supplier?????????
        SupplierQuery param =new SupplierQuery(supplierName,supplierPhone,supplierEmail,supplierAddress,"update",null,null,null);
        Supplier supplier=supplierService.getSupplierByParam(param).get(0);

        model.addAttribute("supplier",supplier);

        //???????????????????????????????????????????????????request????????????????????????????????????????????????supplierQuery???updateSupplier??????????????????????????????????????????????????????????????????????????????
        model.addAttribute("oldSupplierName",supplierName);
        model.addAttribute("oldSupplierPhone",supplierPhone);
        model.addAttribute("oldSupplierEmail",supplierEmail);
        model.addAttribute("oldSupplierAddress",supplierAddress);
        //System.out.println(supplier);

        //return Result.success(supplier,10L);
        return "info/editSupplierUI";
    }

    @RequestMapping("updateSupplier")
    @ResponseBody
    public Result<Object> updateSupplier(SupplierQuery param){ //String oldSupplierName, String oldSupplierPhone, String oldSupplierEmail, String oldSupplierAddress
        supplierService.updateSupplier(param);
        return Result.success();
    }

    @RequestMapping("/deleteSupplierByParam")
    @ResponseBody
    public Result<Object> deleteSupplierByParam(SupplierQuery param){
        supplierService.deleteSupplierByParam(param);
        return Result.success("????????????");
    }

    /* ------------------------------------------------------------------------------------------ */

    @RequestMapping("/customer")
    public String toCustomerList(){
        return "info/customerList";
    }

    @RequestMapping("/getCustomer")
    @ResponseBody
    public Result<Object> getCustomer(CustomerQuery param){
        List<Customer> customers=customerService.getCustomerByParam(param);
        Long counts= customerService.getCounts();
        return Result.success(customers,counts);
    }

    @RequestMapping("/addCustomer")
    @ResponseBody
    public Result<Object> addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return Result.success();
    }

    @RequestMapping("/addCustomerUI")
    public String addCustomerUI(){
        return "info/addCustomerUI";
    }

    @RequestMapping("/deleteCustomerByCustomerNames/{customerNames}")
    @ResponseBody
    public Result<Object> deleteCustomerByCustomerName(@PathVariable("customerNames")String[] customerNames){
        customerService.deleteCustomerByCustomerNames(customerNames);
        return Result.success();
    }

    @RequestMapping("/customer/{customerName}/{customerPhone}/{customerEmail}/{customerAddress}")
    public String getCustomerToUpdate(@PathVariable("customerName")String customerName, @PathVariable("customerPhone")String customerPhone,
                                      @PathVariable("customerEmail")String customerEmail, @PathVariable("customerAddress")String customerAddress, Model model)
    {
        CustomerQuery param =new CustomerQuery(customerName,customerPhone,customerEmail,customerAddress,"update",null,null,null);
        Customer customer=customerService.getCustomerByParam(param).get(0);

        model.addAttribute("customer",customer);

        //???????????????????????????????????????????????????request????????????????????????????????????????????????supplierQuery???updateSupplier??????????????????????????????????????????????????????????????????????????????
        model.addAttribute("oldCustomerName",customerName);
        model.addAttribute("oldCustomerPhone",customerPhone);
        model.addAttribute("oldCustomerEmail",customerEmail);
        model.addAttribute("oldCustomerAddress",customerAddress);

        return "info/editCustomerUI";
    }

    @RequestMapping("updateCustomer")
    @ResponseBody
    public Result<Object> updateCustomer(CustomerQuery param){
        customerService.updateCustomer(param);
        return Result.success();
    }

    @RequestMapping("/deleteCustomerByParam")
    @ResponseBody
    public Result<Object> deleteCustomerByParam(CustomerQuery param){
        customerService.deleteCustomerByParam(param);
        return Result.success("????????????");
    }

}

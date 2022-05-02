package com.csw.service;

import com.csw.common.vo.CustomerQuery;
import com.csw.entity.Customer;
import com.csw.entity.Supplier;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();

    List<Customer> getCustomerByParam(CustomerQuery param);

    Long getCounts();

    void addCustomer(Customer customer);

    void deleteCustomerByCustomerNames(String[] customerNames);

    void updateCustomer(CustomerQuery param);

    void deleteCustomerByParam(CustomerQuery param);
}

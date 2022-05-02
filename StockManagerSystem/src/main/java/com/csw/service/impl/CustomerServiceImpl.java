package com.csw.service.impl;

import com.csw.common.vo.CustomerQuery;
import com.csw.entity.Customer;
import com.csw.entity.Supplier;
import com.csw.mapper.CustomerMapper;
import com.csw.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> getAllCustomer() {
        return customerMapper.getAllCustomer();
    }

    @Override
    public List<Customer> getCustomerByParam(CustomerQuery param) {
        return customerMapper.getCustomerByParam(param);
    }

    @Override
    public Long getCounts() {
        return customerMapper.getCounts();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }

    @Override
    public void deleteCustomerByCustomerNames(String[] customerNames) {
        customerMapper.deleteCustomerByCustomerNames(customerNames);
    }

    @Override
    public void updateCustomer(CustomerQuery param) {
        customerMapper.updateCustomer(param);
    }

    @Override
    public void deleteCustomerByParam(CustomerQuery param) {
        customerMapper.deleteCustomerByParam(param);
    }
}

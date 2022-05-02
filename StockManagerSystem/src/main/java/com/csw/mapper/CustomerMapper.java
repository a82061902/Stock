package com.csw.mapper;

import com.csw.common.vo.CustomerQuery;
import com.csw.entity.Customer;
import com.csw.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> getAllCustomer();

    List<Customer> getCustomerByParam(CustomerQuery param);

    Long getCounts();

    void addCustomer(Customer customer);

    void deleteCustomerByCustomerNames(String[] customerNames);

    void updateCustomer(CustomerQuery param);

    void deleteCustomerByParam(CustomerQuery param);
}

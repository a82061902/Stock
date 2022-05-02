package com.csw.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerQuery extends Page{
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;

    private String oldCustomerName;
    private String oldCustomerPhone;
    private String oldCustomerEmail;
    private String oldCustomerAddress;
}

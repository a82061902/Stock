package com.csw.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierQuery extends Page{
    private String supplierName;
    private String supplierPhone;
    private String supplierEmail;
    private String supplierAddress;
    private String oldSupplierName;
    private String oldSupplierPhone;
    private String oldSupplierEmail;
    private String oldSupplierAddress;

}

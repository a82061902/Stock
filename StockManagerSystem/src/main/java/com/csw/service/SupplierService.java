package com.csw.service;

import com.csw.common.vo.PurchaseQuery;
import com.csw.common.vo.SupplierQuery;
import com.csw.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSupplier();

    List<Supplier> getSupplierByParam(SupplierQuery param);

    Long getCounts();

    void addSupplier(Supplier supplier);

    void deleteSupplierBySupplierNames(String[] supplierNames);

    void updateSupplier(SupplierQuery param);

    void deleteSupplierByParam(SupplierQuery param);
}

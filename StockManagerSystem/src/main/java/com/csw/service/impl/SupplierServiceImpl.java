package com.csw.service.impl;

import com.csw.common.vo.PurchaseQuery;
import com.csw.common.vo.SupplierQuery;
import com.csw.entity.Supplier;
import com.csw.mapper.SupplierMapper;
import com.csw.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public List<Supplier> getAllSupplier() {
        return supplierMapper.getAllSupplier();
    }

    @Override
    public List<Supplier> getSupplierByParam(SupplierQuery param) {
        System.out.println(param);return supplierMapper.getSupplierByParam(param);
    }

    @Override
    public Long getCounts() {
        return supplierMapper.getCounts();
    }

    @Override
    public void addSupplier(Supplier supplier) {
        supplierMapper.addSupplier(supplier);
    }

    @Override
    public void deleteSupplierBySupplierNames(String[] supplierNames) {
        supplierMapper.deleteSupplierBySupplierNames(supplierNames);
    }

    @Override
    public void updateSupplier(SupplierQuery param) {
        supplierMapper.updateSupplier(param);
    }

    @Override
    public void deleteSupplierByParam(SupplierQuery param) {
        supplierMapper.deleteSupplierByParam(param);
    }
}

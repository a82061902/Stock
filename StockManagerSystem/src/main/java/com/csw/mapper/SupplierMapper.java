package com.csw.mapper;

import com.csw.common.vo.SupplierQuery;
import com.csw.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupplierMapper {
    List<Supplier> getAllSupplier();

    List<Supplier> getSupplierByParam(SupplierQuery param);

    Long getCounts();

    void addSupplier(Supplier supplier);

    void deleteSupplierBySupplierNames(String[] supplierNames);

    void updateSupplier(SupplierQuery param);

    void deleteSupplierByParam(SupplierQuery param);
}

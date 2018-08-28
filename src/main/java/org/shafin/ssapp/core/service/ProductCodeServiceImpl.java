/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.core.service;

import org.shafin.ssapp.common.logging.LogMethodIO;
import org.shafin.ssapp.core.dao.ProductCodeDAO;
import org.shafin.ssapp.core.entity.ProductCode;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rezwan
 */
@Slf4j
@Service
public class ProductCodeServiceImpl implements ProductCodeService{
    
    @Autowired
    private ProductCodeDAO productCodeDAO;
    
    @LogMethodIO
    @Override
    public List<ProductCode> getAllProductCodes() {
        List<ProductCode> listProductCodes = productCodeDAO.getAllProductCodes();
        return listProductCodes;
    }
    
    @LogMethodIO
    @Transactional
    @Override
    public ProductCode saveProductCode(ProductCode productCode) {
        return productCodeDAO.saveProductCode(productCode);
    }
    
}

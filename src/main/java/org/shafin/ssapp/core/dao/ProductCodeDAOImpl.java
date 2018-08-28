/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.core.dao;

import org.shafin.ssapp.common.logging.LogMethodIO;
import org.shafin.ssapp.core.entity.ProductCode;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rezwan
 */
@Slf4j
@Repository
public class ProductCodeDAOImpl implements ProductCodeDAO{
    
    @PersistenceContext
    private EntityManager entityManager;

    @LogMethodIO
    @Override
    public List<ProductCode> getAllProductCodes() {
        List<ProductCode> listProductCodes = null;
        Query query = entityManager.createNamedQuery(ProductCode.PRODUCT_CODE_FIND_ALL, ProductCode.class);
        listProductCodes = query.getResultList();
        return listProductCodes;
    }    
    
    @LogMethodIO
    @Override
    public ProductCode saveProductCode(ProductCode productCode){
        return this.entityManager.merge(productCode);
    }
}

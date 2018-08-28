/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.core.dao;

import org.shafin.ssapp.core.entity.ProductCode;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rezwan
 */
@Repository
public interface ProductCodeDAO {
    List<ProductCode> getAllProductCodes();
    ProductCode saveProductCode(ProductCode productCode);
}

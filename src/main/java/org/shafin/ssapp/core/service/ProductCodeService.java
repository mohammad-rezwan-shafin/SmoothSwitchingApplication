/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.core.service;

import org.shafin.ssapp.core.entity.ProductCode;
import java.util.List;

/**
 *
 * @author Rezwan
 */
public interface ProductCodeService {
    List<ProductCode> getAllProductCodes();
    ProductCode saveProductCode(ProductCode productCode);
}

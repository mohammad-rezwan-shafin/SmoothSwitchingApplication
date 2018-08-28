/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.api.helper.converter;

import org.shafin.ssapp.api.dto.ProductCodeDto;
import org.shafin.ssapp.common.logging.LogMethodIO;
import org.shafin.ssapp.core.entity.ProductCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author Rezwan
 */
@Slf4j
public class ProductCodeDtoToEntityConverter extends BaseDtoEntityConverter<ProductCodeDto, ProductCode>{  
    @LogMethodIO
    @Override
    public ProductCode convert(ProductCodeDto productCodeDto) {
        ProductCode productCode = new ProductCode();
        try {
            BeanUtils.copyProperties(productCodeDto, productCode);
        } catch (Exception ex) {
            log.error("modelMapper map Error", ex);
        }        
        return productCode;
    }
}

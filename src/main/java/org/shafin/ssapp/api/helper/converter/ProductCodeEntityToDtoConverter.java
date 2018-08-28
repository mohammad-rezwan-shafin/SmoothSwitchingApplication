/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.api.helper.converter;

import org.shafin.ssapp.core.entity.ProductCode;
import org.shafin.ssapp.api.dto.ProductCodeDto;
import org.shafin.ssapp.common.logging.LogMethodIO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author Rezwan
 */
@Slf4j
public class ProductCodeEntityToDtoConverter extends BaseDtoEntityConverter<ProductCode, ProductCodeDto> {
    @LogMethodIO
    @Override
    public ProductCodeDto convert(ProductCode productCode) {
        ProductCodeDto productCodeDto = new ProductCodeDto();
        try {
            BeanUtils.copyProperties(productCode, productCodeDto);
        } catch (Exception ex) {
            log.error("modelMapper map Error", ex);
        }        
        return productCodeDto;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.api.endpoint;


import org.shafin.ssapp.api.dto.ProductCodeDto;
import org.shafin.ssapp.common.Constants;
import org.shafin.ssapp.common.logging.LogMethodIO;
import org.shafin.ssapp.core.config.Application;
import org.shafin.ssapp.core.entity.ProductCode;
import org.shafin.ssapp.core.service.ProductCodeService;
import java.util.ArrayList;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.shafin.ssapp.api.endpoint.exceptions.EndpointExpection;


import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author Rezwan
 */
@Slf4j
@RestController
public class ProductCodeEndpoint{
    
    @Autowired
    @Qualifier(value = Application.DTO_ENTITY_CONVERSION_SERVICE)    
    private ConversionService conversionService;
    
    @Autowired
    private ProductCodeService productCodeService;
    
//    @CrossOrigin(origins = "http://192.168.56.160:8080")
    @ResponseBody    
    @RequestMapping(
            path = Constants.API_CONTEXT_PRODUCT_CODE_LIST,
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
//    @LogMethodIO
    public List<ProductCodeDto> getProductCodeList(){
        if (true) {
            throw new EndpointExpection("4205.2256.554", "Too Much Expectations!", HttpStatus.EXPECTATION_FAILED);
        }
        
        List<ProductCodeDto> listProductCodeDtosReturn = new ArrayList<>();

        List <ProductCode> listProductCodes = productCodeService.getAllProductCodes();
        for(ProductCode productCode : listProductCodes) {
            ProductCodeDto productCodeDto  = conversionService.convert(
                    productCode, ProductCodeDto.class
            );
            listProductCodeDtosReturn.add(productCodeDto);
        }        
        return listProductCodeDtosReturn;
    }

    @ResponseBody    
    @RequestMapping(
            path = Constants.API_CONTEXT_PRODUCT_CODE_SAVE,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @LogMethodIO
    public ProductCodeDto saveProductCode(@RequestBody ProductCodeDto productCodeDto){ 
        ProductCode productCode = conversionService.convert(
                productCodeDto, ProductCode.class
        );
        
        ProductCode productCodeReturn = productCodeService.saveProductCode(productCode);
        ProductCodeDto productCodeDtoReturn = conversionService.convert(
                productCodeReturn, ProductCodeDto.class
        );
                        
        return productCodeDtoReturn;
    }
}

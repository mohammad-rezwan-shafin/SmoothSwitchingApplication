/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.api.dto;

import java.io.Serializable;

/**
 *
 * @author Rezwan
 */

@lombok.Data
@lombok.EqualsAndHashCode(callSuper = false)
@lombok.ToString
public class ProductCodeDto {// extends BaseDto implements Serializable{
    private String prodCode;
    private String discountCode;
    private String description;
    
    public ProductCodeDto(){
        
    }
}

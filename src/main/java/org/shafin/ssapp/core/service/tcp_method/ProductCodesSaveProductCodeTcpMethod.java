/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.core.service.tcp_method;

import org.shafin.ssapp.common.logging.LogMethodIO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author K-Rezwan-D1-SBD
 */
@Slf4j
@Component(TcpMethodEnum.PRODUCTCODES_SAVEPRODUCTCODE)
public class ProductCodesSaveProductCodeTcpMethod extends BaseTcpMethod implements TcpMethod{
    @LogMethodIO
    @Override
    public String runMethod(String input) {
      return "ProductCodesSaveProductCodeTcpMethod";            
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.core.service.tcp_method;

import org.shafin.ssapp.common.logging.LogMethodIO;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author K-Rezwan-D1-SBD
 */
@Service
public class TcpMethodLocatorImpl implements TcpMethodLocatorService{
    
    @Autowired
    @Qualifier(TcpMethodEnum.PRODUCTCODES_GETALLPRODUCTCODES)
    private TcpMethod productCodesGetAllProductCodesTcpMethod;
    
    @Autowired
    @Qualifier(TcpMethodEnum.PRODUCTCODES_SAVEPRODUCTCODE)
    private TcpMethod productCodesSaveProductCodeTcpMethod;
    
    private HashMap<TcpMethodEnum, TcpMethod> hashMapTcpMethods = new HashMap<>();
    
    
    @PostConstruct
    private void init(){
        this.register(TcpMethodEnum.ProductCodes_getAllProductCodes, productCodesGetAllProductCodesTcpMethod);
        this.register(TcpMethodEnum.ProductCodes_saveProductCode, productCodesSaveProductCodeTcpMethod);
    }
    
    @LogMethodIO
    public void register(TcpMethodEnum tcpMethodType, TcpMethod tcpMethod) {
        this.hashMapTcpMethods.put(tcpMethodType, tcpMethod);
    }    

    @LogMethodIO
    @Override
    public TcpMethod locate(TcpMethodEnum tcpMethodEnum) {
        return this.hashMapTcpMethods.get(tcpMethodEnum);
    }

}

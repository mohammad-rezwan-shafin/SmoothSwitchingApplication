/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.core.service.tcp_method;

import org.shafin.ssapp.common.logging.LogMethodIO;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author K-Rezwan-D1-SBD
 */
public enum TcpMethodEnum {
    ProductCodes_getAllProductCodes (101, TcpMethodEnum.PRODUCTCODES_GETALLPRODUCTCODES),
    ProductCodes_saveProductCode (102, TcpMethodEnum.PRODUCTCODES_SAVEPRODUCTCODE ) ;   
    
    public static final String PRODUCTCODES_GETALLPRODUCTCODES = "TcpMethod_ProductCodes_getAllProductCodes";
    public static final String PRODUCTCODES_SAVEPRODUCTCODE  = "TcpMethod_ProductCodes_saveProductCode";
    
    private static final Map<Integer, TcpMethodEnum> MAP_VALUES = new HashMap<Integer, TcpMethodEnum>();
    
    private final int methodId;
    private final String name;
    
    TcpMethodEnum(int methodId, String name) {
        this.methodId = methodId;
        this.name = name;
    }
    
    static {
        for (TcpMethodEnum tcpMethodEnum : values()) {
            MAP_VALUES.put(tcpMethodEnum.getMethodId(), tcpMethodEnum);
        }
    }

    @LogMethodIO
    public static TcpMethodEnum getTcpMethodEnum(int intValue) {
        return TcpMethodEnum.MAP_VALUES.get(intValue);
    }
    
    
    public int getMethodId(){
        return this.methodId;
    }
    
    public String toSting() {
        return this.name;
    }    
}

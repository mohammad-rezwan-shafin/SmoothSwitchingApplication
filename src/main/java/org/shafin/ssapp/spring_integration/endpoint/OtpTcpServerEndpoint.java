/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.spring_integration.endpoint;

import org.shafin.ssapp.common.logging.LogMethodIO;
import org.shafin.ssapp.core.service.tcp_method.TcpMethod;
import org.shafin.ssapp.core.service.tcp_method.TcpMethodEnum;
import org.shafin.ssapp.core.service.tcp_method.TcpMethodLocatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author K-Rezwan-D1-SBD
 */
@Slf4j
@Controller
public class OtpTcpServerEndpoint {
    
    private static final String DEFAULT_MESSAGE = "Invalid Input Data\n";
    
    @Autowired
    private TcpMethodLocatorService tcpMethodLocatorService;
    
    @LogMethodIO
    public String runTcpMethod(String input) {
        String strReturn = DEFAULT_MESSAGE;
        
        String strArr[] = input.split(" ");
        log.debug(" parsing input :: data Token Count={}", strArr.length);
        if (strArr.length > 0) {
            log.debug("strArr[0]={}", strArr[0]);
        }
        try {
            int methodId = Integer.parseInt( strArr[0].trim() );
            log.debug(" methodId in int Value {}", methodId);
            TcpMethod tcpMethod = tcpMethodLocatorService.locate(
                TcpMethodEnum.getTcpMethodEnum( methodId )
            );
            if (tcpMethod != null) {
                log.debug(
                    "found the TcpMethod for methodId={}; methodClass={}", 
                    strArr[0].trim(),
                    tcpMethod.getClass().getName()
                );
                strReturn = tcpMethod.runMethod(input) + "\n";
            }
        }
        catch(NumberFormatException nfex) {
            log.error("Unexpected Number at the message header!", nfex);
        }
        return strReturn;
    } 
}

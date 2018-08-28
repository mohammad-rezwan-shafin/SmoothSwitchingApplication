/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.api.endpoint.exceptions;

import org.springframework.http.HttpStatus;

/**
 *
 * @author shafin
 */
@lombok.Data
public class EndpointExpection extends RuntimeException{
    private HttpStatus httpStatus;
    private String code;
    private String message;
    
    public EndpointExpection(String code, String Message) {
        super(
            " code:\"" + code +"\"," + 
            " Message:\"" + Message + "\""
        );
        
        this.code = code;
        this.message = message;        
    }
    
    public EndpointExpection(String code, String Message, HttpStatus httpStatus) {
        super(
            " code:\"" + code +"\"," + 
            " message:\"" + Message + "\"," +
            " httpStatus:\"" + httpStatus.toString() + "\""
        );
        
        this.code = code;
        this.message = message;        
    }
}

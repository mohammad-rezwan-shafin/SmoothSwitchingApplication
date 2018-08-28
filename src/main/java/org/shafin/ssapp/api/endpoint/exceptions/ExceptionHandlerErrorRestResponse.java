/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.api.endpoint.exceptions;

import org.shafin.ssapp.common.logging.LogMethodIO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author shafin
 */
@ControllerAdvice
public class ExceptionHandlerErrorRestResponse extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler({EndpointExpection.class})
    @LogMethodIO
    protected ResponseEntity<Object> handleInvalidRequest(RuntimeException runEx, WebRequest request) {
        ErrorResponse errorResponse;
        HttpStatus httpStatusResponse;
        if (runEx instanceof EndpointExpection) { 
            EndpointExpection epEx = (EndpointExpection) runEx;
            errorResponse = new ErrorResponse(epEx.getCode(), epEx.getMessage());
            httpStatusResponse = epEx.getHttpStatus();
        } else {
            errorResponse = new ErrorResponse("-1", "UnknownError");
            httpStatusResponse = HttpStatus.SEE_OTHER;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(runEx, errorResponse, headers, httpStatusResponse, request);
    }
}

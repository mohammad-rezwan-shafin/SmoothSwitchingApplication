/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.api.endpoint.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author shafin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class ErrorResponse {
    private String code;
    private String message;
//    private List<FieldErrorResource> fieldErrors;

    public ErrorResponse() {
    }

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

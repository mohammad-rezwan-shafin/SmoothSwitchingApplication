/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.shafin.ssapp.api.endpoint

import org.shafin.ssapp.common.Constants
import org.shafin.ssapp.api.dto.ProductCodeDto;

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.URLENC

import groovy.util.logging.Slf4j
import spock.lang.Specification
import groovyx.net.http.RESTClient
import org.apache.http.HttpRequest
import org.apache.http.HttpRequestInterceptor
import org.apache.http.protocol.HttpContext      

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType

/**
 *
 * @author shafin
 */
@Slf4j
class ProductCodeEndpointTest extends Specification {
    
    RESTClient restClient
    ObjectMapper jsonMapper
    
    def setupSpec(){
        log.debug("setupSpec() - Runs once per Specification");
    }

    def setup(){
        log.debug ("setup() - Runs before every feature method");
        restClient = new RESTClient("http://192.168.56.160:8080/")
        restClient.client.addRequestInterceptor(
            new HttpRequestInterceptor() {
                void process(HttpRequest httpRequest, HttpContext httpContext) {
                    httpRequest.addHeader(Constants.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                }
            }
        )
        jsonMapper = new ObjectMapper()
    }

    def cleanup(){
        log.debug ("Cleanup method - Runs  after every feature method.");
    }

    def cleanupSpec(){
        log.debug ("cleanupSpec() - Runs only once per specification");
    }
    
    def 'Test #1 : getProductCodeList Response Testing'() {
        given:
        when:
            def response = restClient.get( path: Constants.API_CONTEXT_PRODUCT_CODE_LIST)
            log.info "Response Data = $response.data"
        then:
            response.status == 200
        and:
            response.data != "Greetings from Spring Boot!"
    }
    
    def 'Test #2 : saveProductCodeList Response Testing'() {
        given:
            ProductCodeDto productCodeDto = new ProductCodeDto()
            productCodeDto.prodCode = "02"
            productCodeDto.discountCode = "02"
            productCodeDto.description = "This is a Test Product 02"
        when:
            def response = restClient.post( 
                path: Constants.API_CONTEXT_PRODUCT_CODE_SAVE,
                body: jsonMapper.writeValueAsString(productCodeDto), 
                requestContentType: JSON
            )
            log.debug "Response Data = $response.data"
        then:
            response.status == 200
        and:
            response.data.prodCode == productCodeDto.prodCode
    }
    
}

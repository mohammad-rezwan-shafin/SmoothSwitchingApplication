/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.shafin.ssapp.api.endpoint

import groovy.util.logging.Slf4j
import spock.lang.Specification
import groovyx.net.http.RESTClient


/**
 *
 * @author shafin
 */
@Slf4j
class HelloEndpointTest extends Specification {
    
    RESTClient restClient;
    
    def setupSpec(){
        log.debug("setupSpec() - Runs once per Specification");
    }

    def setup(){
        log.debug ("setup() - Runs before every feature method");
        restClient = new RESTClient("http://192.168.56.160:8080/")
    }

    def cleanup(){
        log.debug ("Cleanup method - Runs  after every feature method.");
    }

    def cleanupSpec(){
        log.debug ("cleanupSpec() - Runs only once per specification");
    }
    
    def 'Test #1 : Default Response Testing'() {
        given:
//        String city = "Eindhoven,nl"

        when:
//        def response = restClient.get( path: '/hello', query: ['q' : city])
        def response = restClient.get( path: '/hello')
        
        log.debug "Response Data = $response.data"

        then:
        response.status == 200

        and:
//        response.responseData.name == "Eindhoven"
        response.data != "Greetings from Spring Boot!"
    }
    
}


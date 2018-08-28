package org.shafin.ssapp.api.endpoint;

import org.shafin.ssapp.common.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloEndpoint{
    
    @RequestMapping(Constants.API_CONTEXT_HELLO)
    public String hello() {
        return "Greetings from Spring Boot!";
    }    
}

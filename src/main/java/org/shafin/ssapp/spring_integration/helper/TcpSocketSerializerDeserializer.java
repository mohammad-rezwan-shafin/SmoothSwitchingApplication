/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.spring_integration.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.serializer.Deserializer;
import org.springframework.core.serializer.Serializer;

/**
 *
 * @author K-Rezwan-D1-SBD
 */
@Slf4j
public class TcpSocketSerializerDeserializer implements Serializer<String>, Deserializer<String> {

    @Override
    public String deserialize(InputStream inputStream) throws IOException {

        String strReturn = null;
        byte[] bytesInput = new byte[inputStream.available()];
        inputStream.read(bytesInput);

        String strInputHexData = DatatypeConverter.printHexBinary(bytesInput);
        log.debug(
            "deserialize :: OTP Socket Server Byte[] request : {}, bytes Available : {}", 
            strInputHexData, 
            bytesInput.length
        );
        
        try{
            strReturn = new String(bytesInput, StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error("Error while Deserializing Transaction Request", e);
        }
        return strReturn;
    }

    @Override
    public void serialize(String stringOutput, OutputStream outputStream) throws IOException {
        
        byte[] bytesOutput = stringOutput.getBytes(StandardCharsets.UTF_8);
        
        outputStream.write(bytesOutput);
        outputStream.flush();
        String strOutputHexData = DatatypeConverter.printHexBinary(bytesOutput);
        log.debug("serialize :: Outgoing TP Socket Server Byte[] response : {}", strOutputHexData);
    }
}

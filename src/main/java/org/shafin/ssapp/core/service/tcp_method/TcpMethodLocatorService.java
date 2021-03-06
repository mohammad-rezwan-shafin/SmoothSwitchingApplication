/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.ssapp.core.service.tcp_method;

import org.shafin.ssapp.core.service.BaseService;

/**
 *
 * @author K-Rezwan-D1-SBD
 */
public interface TcpMethodLocatorService extends BaseService {
    void register(TcpMethodEnum tcpMethodType, TcpMethod tcpMethod);
    TcpMethod locate(TcpMethodEnum tcpMethodEnum);
}

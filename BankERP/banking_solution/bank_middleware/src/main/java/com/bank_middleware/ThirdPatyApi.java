/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank_middleware;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author duncan
 */
@WebService(serviceName = "ThirdPatyApi")
public class ThirdPatyApi {

    
    @WebMethod(operationName = "CheckAccountBalance")
    public String CheckAccountBalance(@WebParam(name = "userName") String userName,@WebParam(name = "password") String password) {
        return new String();
    }
    
    @WebMethod(operationName = "deductAccount")
    public String deductAmount(@WebParam(name = "userName") String userName,@WebParam(name = "password") String password,@WebParam(name = "amount") String amount) {
        return new String();
    }
    
    
    @WebMethod(operationName = "refundAccount")
    public String refundUser(@WebParam(name = "userName") String userName,@WebParam(name = "amount") String password) {
        return new String();
    }
}

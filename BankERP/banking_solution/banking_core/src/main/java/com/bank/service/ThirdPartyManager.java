package com.bank.service;

import com.bank.dto.Account;
import com.bank.dto.Customer;

/**
 *
 * @author duncan
 */
public class ThirdPartyManager {
    /**
     * 
     * @param customer
     * @return True id customer creation succeeded, false otherwise
     */
    public Account createNewCustomer(Customer customer){
        return new Account();
    }
    
    /**
     * 
     * @param account
     * @return True id customer update succeeded, false oterwise
     */
    public boolean deleteCustomer(Account account){
        return true;
    }
    /**
     * 
     * @param account
     * @return boolean. True id customer update succeeded, false oterwise
     */
    public boolean updateCustomer(Account account){
        return true;
    }
}

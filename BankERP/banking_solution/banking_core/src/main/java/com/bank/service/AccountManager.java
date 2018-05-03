package com.bank.service;

import com.bank.dto.Account;

/**
 *
 * @author duncan
 */
public class AccountManager {
    
    /**
     * 
     * @param account
     * @return 
     */
    public Account createNewAccount(Account account){
        return new Account();
    }
    
    /**
     * 
     * @param account
     * @return 
     */
    public boolean deleteAccount(Account account){
        return true;
    }
    
    /**
     * 
     * @param account
     * @return 
     */
    public boolean updateAccount(Account account){
        return true;
    }
    /**
     * 
     * @param account
     * @param amount
     * @return 
     */
    public boolean withdrawFromAccount(Account account,double amount){
        return true;
    }
    
    /**
     * 
     * @param from
     * @param to
     * @param amount
     * @return 
     */
    public boolean tranferBetweenAccounte(Account from, Account to, Double amount){
        return true;
    }
    
    /**
     * 
     * @param account
     * @param amount
     * @return 
     */
    public boolean transerToMpesa(Account account,double amount){
        return true;
    }
    
}

package com.bank.dao;

import com.bank.dto.Account;
import com.bank.dto.AccountStatus;
import java.util.Date;

/**
 *
 * @author duncan
 */
public class AccountDao {
    String getAccount = "Select * from account where id=?";
    String createAccount = "Insert into account(accountNummber,customer_id,creation_date,status) values(?,?,?,?)";
    String deleteAccount = "Delete account where id=?";
    String updateAccount = "Update account set account_number=?,status=? where id=?";
    
    
    public boolean getAccountById(int id){
        return true;
    }
    
    public Account createNewAccount(Account account){
        return new Account();
    }
    
    public boolean deleteAccount(Account account){
        return true;
    }
    
    public boolean updateAccount(Account account){
        return true;
    }
}

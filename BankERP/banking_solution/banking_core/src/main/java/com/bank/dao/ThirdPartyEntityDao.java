package com.bank.dao;

import com.bank.dto.Customer;

/**
 *
 * @author duncan
 */
public class ThirdPartyEntityDao {
    String getCustomer="Select * from third_party_entity where id=?";
    String saveCustomer="Insert into third_party_entity(user_name,hash_pass,expiry_date,status) values(?,?,?,?)";
    String deleteCustomer="Delete third_party_entity where id=?";
    String updateCustomer="Update third_party_entity set first_name=?,second_name=?,dob=? where id=?";
    
    public boolean getCustomerById(int id){
        return true;
    }
    
    public Customer createNewCustomer(Customer account){
        return new Customer();
    }
    
    public boolean deleteCustomer(Customer account){
        return true;
    }
    
    public boolean updateCustomer(Customer account){
        return true;
    }
}

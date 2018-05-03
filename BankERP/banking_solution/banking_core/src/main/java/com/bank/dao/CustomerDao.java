package com.bank.dao;

import com.bank.dto.Customer;

/**
 *
 * @author duncan
 */
public class CustomerDao {
    String getCustomer="Select * from customer where id=?";
    String saveCustomer="Insert into customer(first_name,second_name,dob) values(?,?,?)";
    String deleteCustomer="Delete customer where id=?";
    String updateCustomer="Update cunstomer set first_name=?,second_name=?,dob=? where id=?";
    
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

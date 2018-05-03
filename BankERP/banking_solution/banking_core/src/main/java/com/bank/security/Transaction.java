/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.security;

/**
 *
 * @author duncan
 */
public class Transaction  implements TransactionValidator{
    @Override
    public boolean validateTransacetion(){
        return true;
    }
}

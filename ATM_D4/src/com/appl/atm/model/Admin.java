/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

/**
 *
 * @author Ucang
 */
public class Admin implements Account{
    
    private int AccountNumber;
    private int Pin;
    
    @Override
    public int getAccountNumber() {
        return AccountNumber;
    }

    @Override
    public int getPin() {
        return Pin;
    }
    
    public void setAccountNumber(int AccountNumber){
        this.AccountNumber = AccountNumber;
    }
    
    public void setPin(int Pin){
        this.Pin = Pin;
    }
    
}

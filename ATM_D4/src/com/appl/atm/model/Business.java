/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

/**
 *
 * @author ulina
 */
public class Business extends Customer {
    private final static int INITIAL_WITHDRAWAL = 500;
    private final static int INITIAL_TRANSFER = 500;
    
    //constructor
    public Business (int userAccountNumber, int Pin, double userAvailableBalance, 
            double userTotalBalance, boolean TheBlockStatus, double rfLimit){
    super(accountNumber,pin,availableBalance,totalBalance,blockStatus,trfLimit);
    }
    
    //@override
    
}

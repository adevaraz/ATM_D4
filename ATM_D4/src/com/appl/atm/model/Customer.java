/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

/**
 *
 * @author ASUS
 */
public abstract class Customer implements Account  {
    
    private int accountNumber; // account number
    private int pin; // PIN for authentication
    private double availableBalance; // funds available for withdrawal
    private double totalBalance; // funds available & pending deposits
    private boolean blockStatus; // True if account blocked ,false if account not blocked
    private double trfLimit; // transfer limit based on account type

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the pin
     */
    public int getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * @return the availableBalance
     */
    public double getAvailableBalance() {
        return availableBalance;
    }

    /**
     * @param availableBalance the availableBalance to set
     */
    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * @return the totalBalance
     */
    public double getTotalBalance() {
        return totalBalance;
    }

    /**
     * @param totalBalance the totalBalance to set
     */
    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    /**
     * @return the blockStatus
     */
    public boolean isBlockStatus() {
        return blockStatus;
    }

    /**
     * @param blockStatus the blockStatus to set
     */
    public void setBlockStatus(boolean blockStatus) {
        this.blockStatus = blockStatus;
    }

    /**
     * @return the trfLimit
     */
    public double getTrfLimit() {
        return trfLimit;
    }

    /**
     * @param trfLimit the trfLimit to set
     */
    public void setTrfLimit(double trfLimit) {
        this.trfLimit = trfLimit;
    }
    
        
    

}



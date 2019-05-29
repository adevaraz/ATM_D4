package com.appl.atm.model;

public class Bisnis extends Customer {
    private static double MAX_WITHDRAWAL = 2000;
    private static double MAX_TRANSFER   = 10000;

    public Bisnis(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
    }

    @Override
    public double getMaxWithdrawal() {
        return MAX_WITHDRAWAL;
    }

    @Override
    public double getMaxTransfer() {
        return MAX_TRANSFER;
    }
    
    @Override
    public boolean isBisnis(){
        return true;
    }
}
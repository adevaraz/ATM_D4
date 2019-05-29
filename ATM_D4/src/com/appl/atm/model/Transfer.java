/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import static com.appl.atm.model.Constants.*;

/**
 *
 * @author Fadhil
 */
public class Transfer extends Transaction{
    private double amount;
    private int accountTransfered;

    public Transfer(int userAccountNumber, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmBankDatabase);
    }

    @Override
    public int execute() {
        Customer account = getBankDatabase().getCustomer(getAccountNumber());
        
        if(account.isSiswa()){
            return IS_SISWA;
        }
        
        if(getBankDatabase().getCustomer(accountTransfered)==null){
            return ACCOUNT_NOT_FOUND;
        }
        
        if(accountTransfered == getAccountNumber()){
            return SAME_ACCOUNT;
        }
        
        if(account.isCustomer()) {
            //amount = screen.processInputTheAmountV();
            if(account.getAvailableBalance() < amount){
                //screen.processDisplayNotEnoughSaldo();
                return NOT_ENOUGH_SALDO;
            }
            if(amount == 0){
                //screen.processCanceled();
                return TRANSFER_CANCELED;
            }
            else{
                if (account.insertTransferLog(getBankDatabase().getDate(), amount)) {
                    //accountTransfered = screen.processInputRecipientV();
                    
                        Customer accountTransfer = getBankDatabase().getCustomer(accountTransfered);
                        
                        account.debit(amount);
                        accountTransfer.credit(amount);
                        //screen.processDisplayTransfered();
                        return TRANSFER_SUCCESS;                    
                }
                else{
                    if (account.isBisnis()) {
                        return EXCEED_ONE_TIME_TRANSFER_BISNIS;
                    }
                    if (account.isMasaDepan()) {
                        return EXCEED_ONE_TIME_TRANSFER_MASA_DEPAN;
                    }
                    //screen.precessDisplayMaxOneDayLimitV(account.getMaxTransfer()); //ini bener ga?
                }
            }
        }
        else{
            //screen.processDisplayAccountNotCustomer();
            return NOT_A_CUSTOMER;
        }
        return 0;
    }
    
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public void setAccountTransferred(int accountNumber){
        this.accountTransfered = accountNumber;
    }
    
    public double getMaxT(){
        return getBankDatabase().getCustomer(getAccountNumber()).getDailyTransferLimit();
    }
    /*
       ATMBankDatabase bankDatabase = getBankDatabase();
        ATMScreen screen = getScreen();
        ATMDatabaseControl databaseControl = getControl();
        //ATMBankDatabase bankDatabase = getBankDatabase();
        //ATMScreen screen = getScreen();
        
        tAmount = screen.transferDisplay();
        if(bankDatabase.getAccount(getAccountNumber()).getAvailableBalance() < tAmount){
            screen.AmountNotEnough();
        }
        else{
            if(tAmount > 100){
                screen.MaxTransfer();
            }
            else{
                tAccount = screen.InputAccountNumber();
                
                if(bankDatabase.getAccount(tAccount)!=null && tAccount != getAccountNumber()){
                    databaseControl.credit(bankDatabase.getAccount(getAccountNumber()), tAmount);
                    databaseControl.transfered(bankDatabase.getAccount(tAccount), tAmount);
                    screen.TransferSuccess(tAmount);
                }
                else{
                    if(tAccount == getAccountNumber()){
                        screen.SelfTransfer();
                    }
                    else{
                        screen.AccountNotFound();
                    }
                }
                
                //bankDatabase.debit(tAccount, tAmount);
            }
        }
        
    */
}

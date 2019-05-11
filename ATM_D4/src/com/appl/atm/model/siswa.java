/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;
import com.appl.atm.view.Screen;
/**
 *
 * @author asus
 */
public class siswa extends Customer {
    private Screen screen; // ATM's screen
    private int userAccount; //user account
    public final static int TFLIMIT_STUDENT = 60; 
    public final static int WDLIMIT_STUDENT = 60;
    private BankDatabase bankDatabase;
    private CashDispenser cashDispenser;
    public siswa(int userAccountNumber, BankDatabase atmBankDatabase,CashDispenser atmCashDispenser){
        super();
        userAccount = userAccountNumber;
    }
    
    public boolean validateWithdrawal(int amount){
        screen = new Screen();
    
        if(amount<= WDLIMIT_STUDENT){
            return true;
        } else {
            screen.displayMessageLine("you have exceeded the maximum withdrawal limit ($50)");
            return false;
        }
    }
    public boolean validateTransfer(int amount){
        screen = new Screen();
        if(amount<= TFLIMIT_STUDENT){
            return true;
        } else {
            screen.displayMessageLine("you have exceeded the maximum transfer limit ($50)");
            return false;
        }
    }
}

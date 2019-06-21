/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.Bisnis;
import static com.appl.atm.model.Constants.*;
import com.appl.atm.model.Customer;
import com.appl.atm.model.Deposit;
import com.appl.atm.model.DepositSlot;
import com.appl.atm.model.MasaDepan;
import com.appl.atm.model.Siswa;
import com.appl.atm.model.Transaction;
import com.appl.atm.view.AdminViewController;
import com.appl.atm.view.DepositViewControler;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
import com.appl.atm.view.View;
import java.util.HashMap;
/**
 *
 * @author Zara Veda
 */
public class ConfirmDepositController extends TransactionController {
    DepositSlot updateSlot;
    BankDatabase bankDatabase;
    Keypad keypad;
    Screen screen;
    
    public ConfirmDepositController(DepositSlot theDepositSlot,
        BankDatabase theBankDatabase, Keypad theKeypad, Screen theScreen) {
        super(theKeypad, theScreen);
        
        updateSlot = theDepositSlot;
        bankDatabase = theBankDatabase;
    }
    
    public int run(){
        screen = getScreen();
        keypad = getKeypad();
        DepositViewControler screenView = new DepositViewControler();
        
        /* Getting the list of deposit slot */
        HashMap<Customer, Double> theList = bankDatabase.getList();
        
        screenView.showList(bankDatabase.getList());
        screen.displayMessage("\nChoose the account number (or 0 to cancel) : ");
        int choosen = keypad.getInput();

        if(choosen != 0) {
            updatingSlot(bankDatabase, choosen);

            /* Showing the updated deposit slot */
            screenView.showList(bankDatabase.getList());
        } else {
            screen.displayMessageLine("Back to menu..");
        }
        
        return 0;
    }
    
    private void updatingSlot(BankDatabase bankDatabase, int choosen) {
        /* Deleting the deposit slot that accepted by admin */
        updateSlot.deleteList(bankDatabase.getList(), bankDatabase.getCustomer(choosen),
            bankDatabase);
    }
}

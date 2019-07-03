/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import static com.appl.atm.model.Constants.*;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Annazar
 */
public class Deposit extends Transaction {

    private double amount; // amount to deposit
    private DepositSlot depositSlot; // reference to deposit slot
    private boolean acceptedStatus;

    // Deposit constructor
    public Deposit(int userAccountNumber, BankDatabase atmBankDatabase,
	    DepositSlot atmDepositSlot) {

	// initialize superclass variables
	super(userAccountNumber, atmBankDatabase);
	depositSlot = atmDepositSlot;
    }

    @Override
    public int execute() {
        BankDatabase bankDatabase = getBankDatabase();
	Customer account = bankDatabase.getCustomer(getAccountNumber());

//        Boolean isEnvelopeReceived = depositSlot.isEnvelopeReceived(bankDatabase.getList(),
//                account, amount, bankDatabase);

        if (isEnvelopeReceived(bankDatabase, account)) {
	    account.credit(amount);
	    return DEPOSIT_SUCCESSFUL;
	} else {
	    return ENVELOPE_IS_NOT_RECEIVED;
	}
    }

    boolean isEnvelopeReceived(BankDatabase bankDatabase, Customer account) {
        return  (depositSlot.isEnvelopeReceived(bankDatabase.getList(),
            account, amount, bankDatabase));
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    public DepositSlot getDepositSlot() {
	return depositSlot;
    }

    public void setDepositSlot(DepositSlot depositSlot) {
	this.depositSlot = depositSlot;
    }
}

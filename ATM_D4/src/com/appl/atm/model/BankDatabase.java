/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Annazar
 */
public class BankDatabase {
    
    private ArrayList<IAccount> accounts; // array of Accounts
    private HashMap<Customer, Double> envelopeList;

    public BankDatabase() {
        accounts = new ArrayList<IAccount>();
        accounts.add(new Admin(1, 3333));
	accounts.add(new MasaDepan(1234, 4321, 1000.0, 1200.0));
	accounts.add(new MasaDepan(8765, 5678, 200.0, 200.0));
        accounts.add(new Bisnis(1000, 1000, 1000, 1200)); //PLN
        accounts.add(new Bisnis (2000, 1000, 1000, 1200));//PDAM
        accounts.add(new Bisnis(3000, 3000, 1000, 1200)); //TV/Internet berlangganan
        accounts.add(new Bisnis(4000, 4000, 1000, 1200)); //Asuransi

        envelopeList = new HashMap<Customer, Double>();
    }
    
    public void addAccount(Siswa newSiswa){
        accounts.add(new Siswa(newSiswa.getAccountNumber(), newSiswa.getPin(),
                newSiswa.getAvailableBalance(), newSiswa.getTotalBalance()));
    }
    
    public void addAccount(Bisnis newBisnis){
        accounts.add(new Bisnis(newBisnis.getAccountNumber(), newBisnis.getPin(),
                newBisnis.getAvailableBalance(), newBisnis.getTotalBalance()));
    }
    
    public void addAccount(MasaDepan newMasaDepan){
        accounts.add(new MasaDepan(newMasaDepan.getAccountNumber(), newMasaDepan.getPin(),
                newMasaDepan.getAvailableBalance(), newMasaDepan.getTotalBalance()));
    }
    
    public IAccount getAccount(int accountNumber) {
	int i;
        for (i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                return accounts.get(i);
            }
        }
        return null; // if no matching account was found, return null
    }

    public Customer getCustomer(int accountNumber) {
		int i;
        for (i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber && accounts.get(i).isCustomer()) {
                return (Customer)accounts.get(i);
            }
        }
        return null; // if no matching account was found, return null
    }

    public int authenticateUser(int userAccountNumber, int userPIN) {
    IAccount userAccount = getAccount(userAccountNumber);

    if(userAccount != null)
	{
	    if(userAccount.getPin() == userPIN)
	    {
		return 1;
	    }
	    else
	    {
		return 2;
	    }
	}
	else
	{
	    return 2;
	}
    }

    public HashMap<Customer, Double> getList() {
        return envelopeList;
    }

    public void setList(Customer theAccount, double amount) {
        envelopeList.put(theAccount, amount);
    }

    public void updateList(Customer theAccount) {
        if(envelopeList.containsKey(theAccount)) {
            envelopeList.remove(theAccount);
        }
    }
    
    public boolean isUserExist(int accountNumber){
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }

}

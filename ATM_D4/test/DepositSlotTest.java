/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.Customer;
import com.appl.atm.model.DepositSlot;
import com.appl.atm.model.MasaDepan;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;



/**
 *
 * @author Ucang
 */
public class DepositSlotTest {
    
    private DepositSlot depositSlot;
    private HashMap<Customer, Double> envelopes;
    private double amount;
    private BankDatabase bankDatabase;
    private MasaDepan theCustomer;
    
    @Before
    public void createAndSet(){
        depositSlot = new DepositSlot();
        envelopes = new HashMap<>();
        amount = 100;
        bankDatabase = new BankDatabase();
        theCustomer = (MasaDepan)bankDatabase.getCustomer(1234);
        envelopes.put(theCustomer, amount);
    }
    
    
    @Test
    public void addListTest(){
         
        // Act
        boolean isCustomerInEnvelopeList = depositSlot.addList(envelopes,theCustomer,amount, bankDatabase);
        
        // Assert
        assertFalse(isCustomerInEnvelopeList);
        
    }
    
    @Test
    public void isEnvelopeReceivedTest(){
        
        
        // Act
        boolean envelopeCustomerStatus = depositSlot.isEnvelopeReceived(envelopes,theCustomer, amount, bankDatabase);
        
        // Assert
        assertFalse(envelopeCustomerStatus);
        
    }
    
    
}

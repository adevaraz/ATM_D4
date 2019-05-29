/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.appl.atm.model.CashDispenser;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Ucang
 */
public class CashDispenserTest {
    
    private CashDispenser cashDispenser;
    
    @Before
    public void create(){
        cashDispenser = new CashDispenser();
    }
    
    @Test
    public void AddCashDispenserTest(){
        
        // Arrage 
        int amountAdded = 100;
        
        // Act
        int totalMoney = cashDispenser.AddCashDispenser(amountAdded);
        
        // Assert
        assertEquals("Test",2500,cashDispenser.getAmountCashDispenser());
        
    }
    
}

package practice;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TaxPractice.Tax;

public class TaxTest {
    
    static Tax tax;
    
    public TaxTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        tax = new Tax();
        System.out.println("In setUp");
    }
    
    @AfterAll
    public static void tearDownClass() {
                    
        System.out.println("In tearDown");
    }
    
    @BeforeEach
    public void setUp() {        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calcTax method, of class Tax.
     */
    
    @Test
    public void testCalcTax() {
        
        //fail("Not yet completed!");
        
    }
    
    @Test
    public void testZeroTax(){
        
        Tax tax = new Tax();
        //assertEquals(double expected, double actual, double delta) 
                           //ocekivana,prihvatljiv,dozvoljena razlika(expected-actual)
        assertEquals("Tax on zero income is not zero", 0, tax.calcTax(0, 0), 0);
        
    }
    
    @Test
    public void testOneStudentTaxDeduction(){
        
        Tax tax = new Tax();
        
        //assertEquals(double expected, double actual, double delta) 
                           //ocekivana,prihvatljiv,dozvoljena razlika(expected-actual)     
        assertEquals("The $300 student discount was not applied", 2000, tax.applyStudentDeduction(2300, 1), 0);
    }

   
        
    }
    


package practice;



import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import TaxPractice.Tax;

class TaxExceptionTest {

	@Test
	@Disabled
    public void testForNegativeGrossIncome(){
        
		
        Tax tax = new Tax();
        
        tax.calcTax(-100, 2);
        
        throw new NullPointerException("grossIncome in calcTax() can't be negative.");}
    


}

package com.RegUserWith_CreditCard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductAndGc;
import com.providio.commonfunctionality.findAStore;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__simpleProductAndGc_InCC extends baseClass {
	
	  
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void simpleProduct_Gc() throws InterruptedException {
		
		if(isLoggedIn) {			
		
			// to pick the store
		     findAStore  store = new findAStore();
		     store.findStore();
		     
			//simple proudct
			SimpleProductAndGc spGc = new SimpleProductAndGc();
			spGc.simpleProductAndGc();
			 
			 //checkoutProcess				        
		     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
		     cp.checkoutprocess();
		     
		     //credit card
		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();			     
		     cc.paymentByCreditCard();
	 } else {
        Assert.fail("User not logged in");
    }
 }
	
}

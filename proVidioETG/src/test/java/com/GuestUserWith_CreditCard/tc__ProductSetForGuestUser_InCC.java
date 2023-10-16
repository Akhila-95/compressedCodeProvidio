package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.ProductSet;
import com.providio.commonfunctionality.findAStore;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;
public class tc__ProductSetForGuestUser_InCC extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	@Test
	public void productSet() throws InterruptedException {
		
			//launching browser
				launchBrowsering lb = new launchBrowsering();
				lb.chromeBrowser();
			
				
			// to pick the store
		     findAStore  store = new findAStore();
		     store.findStore();
			     
			//product set		
				ProductSet  set = new ProductSet ();
				set.productSet();
				
		    //checkoutProcess		        
				tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	         
	            cp.checkoutprocess();
	            
            //payment process             
			     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();		     
			     cc.paymentByCreditCard();

	        } 
}


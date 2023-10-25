package com.RegUserWith_CreditCard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.Scenarios.SearchingProduct;
import com.providio.Scenarios.SimpleProductAndGc;
import com.providio.commonfunctionality.findAStore;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.paymentProccess.tc__MiniCartCheckoutButton;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Reg_InCC extends baseClass{
	 
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void bundle_GcAndAllPromotions() throws InterruptedException {
		
		if(isLoggedIn) {   

		// to pick the store
		     findAStore  store = new findAStore();
		     store.findStore();	
				
		//pramotions
			Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
			bgs.bundleGcandallpromotions();
		
			//simple proudct
			SimpleProductAndGc spGc = new SimpleProductAndGc();
			spGc.simpleProductAndGc();
			 	
			
		//searching a product 		
			 SearchingProduct sp = new SearchingProduct();
			 sp.searchingProduct();	
			
		  //checkoutProcess		        
	        tc__MiniCartCheckoutButton cp = new tc__MiniCartCheckoutButton();         
			cp.checkoutprocess();
      
		//payment process
			tc__CreditCardPaymentProcess tc = new tc__CreditCardPaymentProcess();			              
			tc.paymentByCreditCard();
	     
		}else {
		   	 Assert.fail("User not logged in");
		   }
		 
	}
}

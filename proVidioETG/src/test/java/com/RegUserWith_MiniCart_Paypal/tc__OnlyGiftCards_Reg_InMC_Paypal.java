package com.RegUserWith_MiniCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.giftCard;
import com.providio.commonfunctionality.findAStore;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCards_Reg_InMC_Paypal extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
		 
			// to pick the store
		     findAStore  store = new findAStore();
		     store.findStore();
		     
		    //adding GC into cart
		     giftCard gc = new giftCard();
		     gc.giftCards();
		     
		 //checkout from mini cart by paypal	        
	        tc__CheckOutProcessByPayPal checkOutProcessByPayPal= new tc__CheckOutProcessByPayPal();
	        checkOutProcessByPayPal. checkoutprocessFromMiniCart();
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}

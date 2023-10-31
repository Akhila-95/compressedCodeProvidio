												package com.GuestUserWith_GiftCard;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__OrderByGc_GuestUser extends baseClass {
	 
	@Test
	public void paymentByGiftCardInGuestUser() throws InterruptedException  {
		
		
		//launching the browser and passing the url into it
				launchBrowsering lb = new launchBrowsering();
				lb.chromeBrowser();
				
				
				// to pick the store
			     findAStore  store = new findAStore();
			     store.findStore();
	          
	          // selects a random catgory and product add to cart
		          navigationProccess navProccess = new navigationProccess();
		          navProccess.commonNavigationProccess();
	          
	          //checkoutProcess				        
			     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
			     cp.checkoutprocess();
			     
			  //gc payment 
			     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
			     gc.paymentByGiftCard();
			   
			     
		}
}

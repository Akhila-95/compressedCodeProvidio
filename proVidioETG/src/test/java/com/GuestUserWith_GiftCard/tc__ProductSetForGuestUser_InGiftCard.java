package com.GuestUserWith_GiftCard;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.ProductSet;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.findAStore;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;
public class tc__ProductSetForGuestUser_InGiftCard extends baseClass{
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
            
           //gc payment 
		     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
		     gc.paymentByGiftCard();
			   

	        } 
}


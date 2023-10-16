package com.GuestUserWith_GiftCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.VariationProduct;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.attributesSelection;
import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;


public class tc__VariationProductForGuestUser_InGiftCard extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test
	public void variationProduct() throws InterruptedException {
		 

			//launching browser
				launchBrowsering lb = new launchBrowsering();
				lb.chromeBrowser();
		 	
			// to pick the store
			     findAStore  store = new findAStore();
			     store.findStore();
				
			//variation product	 
				 VariationProduct product = new VariationProduct();
				 product.variationProduct();
				 
	      //paypal checkout form view cart page
		 	    tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();	         
		 	    paypal.checkoutprocessFromViewCart();
    
	     //checkoutProcess	        
				tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();         
				cp.checkoutprocess();

		 //gc payment 
			     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
			     gc.paymentByGiftCard();
		   


	 }
}


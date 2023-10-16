package com.GuestUserWith_ViewCart_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.ProductSet;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.pageObjects.ProductSetFromExcel;
  
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
public class tc__ProductSetForGuestUser_InVC_Paypal extends baseClass{
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
	 	    
	           //paypal checkout form view cart page
	 	         tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();	         
	 	         paypal.checkoutprocessFromViewCart();

	        } 
}


package com.GuestUserWith_GcAndPaypal;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.SimpleProduct;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.pageObjects.GiftCertificate;
import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__SimpleProductForGuestUser_InGcAndPaypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test
	public void simpleProduct() throws InterruptedException {
		 
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
			
			// to pick the store
		     findAStore  store = new findAStore();
		     store.findStore();
		     
			
			//simple product
		    SimpleProduct sp = new SimpleProduct();
		    sp.simpleProdcut();
		    
	        //checkoutProcess	        
	        tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	        
	        cp.checkoutprocess();
            
	      //gc and paypal
			  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
			  gcAndPaypal.paymentProccessByGCandPaypal();

	        
	        }
	        
	  
}


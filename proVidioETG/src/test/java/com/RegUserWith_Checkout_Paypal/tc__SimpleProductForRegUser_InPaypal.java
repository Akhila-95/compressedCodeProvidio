package com.RegUserWith_Checkout_Paypal;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.SimpleProduct;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;


public class tc__SimpleProductForRegUser_InPaypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void simpleProduct() throws InterruptedException {
		 

			if(isLoggedIn) {      
					 			
			 // to pick the store
			     findAStore  store = new findAStore();
			     store.findStore();
				     
			 //simple product
			    SimpleProduct sp = new SimpleProduct();
			    sp.simpleProdcut();
			    
		      //checkoutProcess	        
		        tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	        
		        cp.checkoutprocess();		       
		        
			  //paypal process from checkout page
				 tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
				 cpp.checkoutprocessFromCheckout();

			 }else {
			   	 Assert.fail("User not logged in");
			   }
	        } 
}


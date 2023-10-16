package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.ProductSet;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
public class tc__ProductSetForReg_InVC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void productSet() throws InterruptedException {

			if(isLoggedIn) {
			//product set		
				ProductSet  set = new ProductSet ();
				set.productSet();
		 	    
	    	 //paypal checkout form view cart page
	 	          tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();	         
	 	          paypal.checkoutprocessFromViewCart();   

	        } else {
		        Assert.fail("User not logged in");
		    }
		 }
}


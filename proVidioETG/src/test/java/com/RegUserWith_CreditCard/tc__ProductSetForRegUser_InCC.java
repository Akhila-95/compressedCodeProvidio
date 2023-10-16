package com.RegUserWith_CreditCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.ProductSet;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.ProductSetFromExcel;
  
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;
public class tc__ProductSetForRegUser_InCC extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void productSet() throws InterruptedException {

			if(isLoggedIn) {

			//product set		
				ProductSet  set = new ProductSet ();
				set.productSet();
		 	    
		    //checkoutProcess		        
				tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	         
	            cp.checkoutprocess();
	            
            //payment process             
		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();		     
		     cc.paymentByCreditCard();

	        }   else {
		        Assert.fail("User not logged in");
		    }
		 }
}


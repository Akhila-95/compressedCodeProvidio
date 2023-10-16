package com.RegUserWith_CreditCard;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.VariationProduct;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.attributesSelection;
import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.validatingInstock;

import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__VariationProductRegUser_InCC extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	  
	 @Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void variationProduct() throws InterruptedException {
		 
		 if(isLoggedIn) {
			
			// to pick the store
			     findAStore  store = new findAStore();
			     store.findStore();
				
			//variation product	 
				 VariationProduct product = new VariationProduct();
				 product.variationProduct();
				 
	         //checkoutProcess	        
	            tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();          
	            cp.checkoutprocess();
	            
	         //payment process         
			     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();		     
			     cc.paymentByCreditCard();


		 }
		 
		  else {
		        Assert.fail("User not logged in");
		    }
	 }
}


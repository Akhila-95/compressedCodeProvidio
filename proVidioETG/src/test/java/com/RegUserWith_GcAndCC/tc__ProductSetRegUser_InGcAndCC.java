package com.RegUserWith_GcAndCC;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.ProductSet;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.ProductSetFromExcel;
  
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__ProductSetRegUser_InGcAndCC extends baseClass{
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
		        
		     //semi gc and cc 
				Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
				gCandCC.paymentProccessByGCandCC(driver);
		        

	    
		 }else {
		        Assert.fail("User not logged in");
		    }
		}
}


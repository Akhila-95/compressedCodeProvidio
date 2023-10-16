package com.RegUserWith_CreditCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.giftCard;
import com.providio.pageObjects.GiftCertificate;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCards_Reg_InCC extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
		 
			//adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards();
			 
			
			 tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
		     cp.checkoutprocess();
		     
		   //payment process             
		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();		     
		     cc.paymentByCreditCard();
		     
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}

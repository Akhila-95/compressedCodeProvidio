package com.RegUserWith_CreditCard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Validations.Checkout_Validation;
import com.providio.commonfunctionality.BuyNowInPDP;
import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.testcases.baseClass;

public class tc__By_BuyNow_Button extends baseClass{
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void byNowButton() throws InterruptedException {
		if(isLoggedIn) {   

			 // to pick the store - have to check whether buy now button with pick up store 
			     findAStore  store = new findAStore();
			     store.findStore();
			
			  //selects a random category and product add to cart
		          navigationProccess navProccess = new navigationProccess();
		          navProccess.configuredCategoryForBuyNow();
		       
		      //click on buy now    
		          BuyNowInPDP buyNow= new BuyNowInPDP();
		          buyNow.clickOnBuyNow(driver);
	    	    
		          Thread.sleep(5000);
			
	    		if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
	    			
	    			 Checkout_Validation checkout= new Checkout_Validation();
	    		 //validate the final place the order page
	    			 checkout.validatePlacetheOrderPage();
	    		
	    	     //ordernumberandOrderdate
	    			 checkout.ordernumberandOrderdate();
	    			 //Thread.sleep(5000);
	    			}
	    	
    	}else {
		   	 Assert.fail("User not logged in");
		   }
		 
	}
}

package com.providio.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.checkOutPage;
import com.providio.testcases.baseClass;

public class AddressDetails extends baseClass {

	public void address() throws InterruptedException {
		
		   //CommonProccessFromMiniCartForViewCartAndCheckout 
        CommonProccessFromMiniCartForViewCartAndCheckout  commonProccess= new CommonProccessFromMiniCartForViewCartAndCheckout ();
        
		  //verifying the availability of shipping or pick store size
        
        List<WebElement> shippingLabel= driver.findElements(By.xpath("(//h2[contains(text(),'Shipping')])[2]"));
        
        List<WebElement> pickUpStoreLabel= driver.findElements(By.xpath("(//span[contains(text(),'Store Pickup')])[1]")); 
        
        List<WebElement> enterAddressList= driver.findElements(By.xpath("(//button[contains(text(),'Enter Address')])[2]")); 
        
        List<WebElement> storePickUpList= driver.findElements(By.xpath("(//span[contains(text(),'Store Pickup')])[2]")); 
        
        if(shippingLabel.size()>0)  {
        	
        	WebElement shippingLabelDisplay= driver.findElement(By.xpath("(//h2[contains(text(),'Shipping')])[2]"));
            	
            	if(shippingLabelDisplay.isDisplayed() && (enterAddressList.size()>0)) {
            		
	            	checkOutPage cp = new checkOutPage(driver);
	            	
	            	//selecting shipping address
	            	commonProccess.selectShippingAddress(cp);

		            commonProccess.selectPaymentMethod(cp);
		            
            	}else if(pickUpStoreLabel.size()>0) {
	            	
            	    // enter the name and address details
            	    checkOutPage cp = new checkOutPage(driver);
	            	
	            	//when bipois are enabled,store pickup works, and this code executes				            				            	
	            	commonProccess.selectPaymentMethod(cp);
	            		
	            	//entering billing address details			            		
	            	//commonProccess.selectBillingAddress(cp);
	            }		   
        
        } if(enterAddressList.size()>0 && storePickUpList.size()>0) {
        	
           WebElement enterAddressDisplay= driver.findElement(By.xpath("(//button[contains(text(),'Enter Address')])[2]"));
           
               if(enterAddressDisplay.isDisplayed()) {
            	   
	            	test.info("In cart some  products are from store so , we have to enter the address to deliver normal products");
	            	
	            	//total div of multi shipping
	            	 WebElement parentmultiShipping= driver.findElement(By.xpath("(//div[contains(@class,'multi-shipping')])[1] "));
	            	 
	            	 //click on enter address
	            	 WebElement enterAddress= parentmultiShipping.findElement(By.xpath("((//div[contains(@class,'multi-shipping')])[1]//form[@id='dwfrm_shipping'])[1]"));
	            	
	            	 enterAddress.click();
	            	
	            	 
	            	 // enter the name and address details
	            	 checkOutPage cp = new checkOutPage(driver); 		            	 
	            	 
	            	 Thread.sleep(1000);
	            	 commonProccess.selectShippingAddress(cp);
	            	 test.info("Entered the address");
	            	 
	            	
	            	 //save the address
	            	 WebElement saveTheAddressButton= driver.findElement(By.xpath("(//button[contains(@class,'save-shipment')])[2]"));
	            	 JavascriptExecutor js = (JavascriptExecutor)driver;
			    		js.executeScript("window.scrollBy(0,500)", "");            	
                        js.executeScript("arguments[0].click();",saveTheAddressButton);
                        logger.info("Saved the address");
	            	
                     Thread.sleep(2000);
                     commonProccess.selectPaymentMethod(cp);
                     Thread.sleep(3000);
	            	 //click on enter address
               }
         
    	}else {
        	//if Only Gc added to cart then this snippet executes 
    		 List<WebElement> billingAddress= driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));		            	
        	 checkOutPage cp = new checkOutPage(driver);
        	 
            	 if(billingAddress.size()>0) {
            		WebElement billingAddressDisplay= driver.findElement(By.xpath("//label[contains(text(),'Billing Address')]"));
            		if(billingAddressDisplay.isDisplayed()) {
	            		 //test.info("As only Gift cart is in cart ");
	            		 commonProccess.selectBillingAddress(cp);
	            		 	
	            		 commonProccess.selectPaymentMethod(cp);
            		}
        	 }		          
    } 
	}
}

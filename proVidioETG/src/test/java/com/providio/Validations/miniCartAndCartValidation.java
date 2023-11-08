package com.providio.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.miniCartPage;
import com.providio.testcases.baseClass;

public class miniCartAndCartValidation extends baseClass {

	
	
		  
	    public void validateMiniCartClick() throws InterruptedException {
	    	
	    	// validating the button in minicart
	    	List<WebElement> minicartList = driver.findElements(By.xpath("(//h1)[1]"));
	    	if(minicartList.size()>0) {
		    	test.info("Verify the mini-cart button is clicked");
		    	
		        WebElement minicart = driver.findElement(By.xpath("(//h1)[1]"));
		        String actualTitleofminicart = minicart.getText();
		        String expectedTitleminicart = "Your shopping cart";
		        Thread.sleep(2000);
		        logger.info(minicart.getText());
		        if (actualTitleofminicart.equals(expectedTitleminicart)) {
		            test.pass("Successfully clicked on the mini cart button");
		            logger.info("Successfully clicked on the mini cart button");
		
		        } else {
		            //test.fail("Clicked failed on the mini cart button");
		            logger.info("Clicked failed on the mini cart button");
		            //reclick if any error occurs
		            //reClickMiniCartButton();
		            
		        }
		        
		        test.info("Verify the viewcart, checkout, paypal buttons and products are displayed");
		        List<WebElement> productsinthecart = driver.findElements(By.xpath("//div[@class ='line-item-name']"));
		        logger.info(productsinthecart.size());
		        
		        WebElement viewcarButton = driver.findElement(By.xpath("//a[contains(@class, 'checkout-btn') and contains(text(), 'View Cart')]"));
		        boolean displaycartbutton = viewcarButton.isDisplayed();
		        logger.info(displaycartbutton);
		        WebElement checkOutProcess = driver.findElement(By.xpath("//a[contains(@class, 'checkout-btn') and contains(@class, 'btn-primary') and contains(text(), 'Checkout')]"));
		        boolean displaycheckOut = checkOutProcess.isDisplayed();
		        logger.info(displaycheckOut);
		        
		        if(productsinthecart.size()>0 && displaycartbutton && displaycheckOut ) {
		        	test.pass("Successfully displayed the viewcart, checkout, and products, The number of products are: "+ productsinthecart.size());
		            logger.info("Successfully displayed the viewcart, checkout,  and products");
		        	
		        }else {
		            test.fail(" Not displayed the viewcart, checkout, paypal buttons and products");
		            logger.info("Not displayed the viewcart, checkout, paypal buttons and products");
		        }
		        
		        
		        // to verify paypal button display  in minicart 
		        List<WebElement> salesforceButtonList= driver.findElements(By.xpath("//div[contains(@class,'salesforce')]"));
				List<WebElement> brainPayPalButtonList = driver.findElements(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
				if(salesforceButtonList.size()>0 ) {			
					WebElement salesforceButton= driver.findElement(By.xpath("//div[contains(@class,'salesforce')]"));
					boolean displaySalesforcePaypal = salesforceButton.isDisplayed();
					if(displaySalesforcePaypal) {				
						test.pass("Salesforce paypal button is displayed after clicking the minicart button");
					}else {
						test.fail("Salesforce paypal button is not displayed after clicking the minicart button");
					}
		    
				}else if(brainPayPalButtonList.size()>0) {
					WebElement brainPayPalButton = driver.findElement(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
					boolean displaybraintreePaypal = brainPayPalButton.isDisplayed();
					if(displaybraintreePaypal) {				
						test.pass("brain tree paypal button is displayed after clicking the minicart button");
					}else {
						test.fail("brain tree  paypal button is not displayed after clicking the minicart button");
					}
				}
	    	}
	    }
	    
	    public void validateViewCartClick() {
	    	test.info("Verify the view-cart button is clicked");
	        WebElement viewcart = driver.findElement(By.xpath("//h4"));
	        String actualTitleofviewcart = viewcart.getText();
	        String expectedTitleviewcart = "Order Summary";
	        logger.info(viewcart.getText());
	        if (actualTitleofviewcart.equals(expectedTitleviewcart)) {
	            test.pass("Successfully clicked on the view cart button");
	            logger.info("Successfully clicked on the view cart button");
	        } else {
	            test.fail("Clicked failed on the view cart button");
	            logger.info("Clicked failed on the view cart button");
	        }	        
	    }

	    public void reClickMiniCartButton() throws InterruptedException {
	    	
	    	miniCartPage mc = new miniCartPage(driver);
	        mc.clickcartbuttonjs(driver);
	        
	        WebElement reminicart = driver.findElement(By.xpath("(//h1)[1]"));
	        String reactualTitleofminicart = reminicart.getText();
	        String reexpectedTitleminicart = "Your shopping cart";
	        Thread.sleep(2000);
	        logger.info(reminicart.getText());
	        if (reactualTitleofminicart.equals(reexpectedTitleminicart)) {
	            test.pass("Successfully clicked on the mini cart button");
	            logger.info("Successfully clicked on the mini cart button");

	        } else {
	            test.fail("Clicked failed on the mini cart button");
	            logger.info("Clicked failed on the mini cart button");

	        }
	    	
	    }
	    
	    public void validateCheckoutafterClick() {
	    	test.info("Verify the view-cart button is clicked");
	        WebElement viewcart = driver.findElement(By.xpath("(//h2[contains(text(), 'Shipping')])[2]"));
	        String actualTitleofviewcart = viewcart.getText();
	        String expectedTitleviewcart = "Shipping";
	        logger.info(viewcart.getText());
	        if (actualTitleofviewcart.equals(expectedTitleviewcart)) {
	            test.pass("Successfully clicked on the checkout button button");
	            logger.info("Successfully clicked on the checkout button button");
	        } else {
	            test.fail("Clicked failed on the checkout button button");
	            logger.info("Clicked failed on the checkout button button");
	        }
	        
	        
	    }
	}


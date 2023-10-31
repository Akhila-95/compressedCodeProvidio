//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.GuestUserWith_CreditCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__PdpPagewithGuestuser extends baseClass {

	SoftAssert softAssert = new SoftAssert();

	@Test
	public void PDPpage() throws InterruptedException {
		
		//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
				
		// to pick the store
		     findAStore  store = new findAStore();
		     store.findStore();
		     
		 //navigates to pdp page randomly
		     navigationProccess nav = new navigationProccess();
		     nav.commonNavigationProccess();
     
		  //review in pdp page
		     writeReviewForProduct();
      

	     // Step 6: Proceed to Checkout
	        tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();
	        cp.checkoutprocess();
	        
         //payment process            
            tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();          
            cc.paymentByCreditCard(); 

	}




	// Step 4: Write a Review for the Product
	private void writeReviewForProduct() throws InterruptedException {
		List<WebElement> bopis =driver.findElements(By.xpath("(//span[@class='write-question-review-button-text font-color-gray-darker'])[1]"));
		productDescriptionPage pdp = new productDescriptionPage(driver);
		
		if(!(bopis.size()>0) && (driver.findElement(By.xpath("(//span[@class='write-question-review-button-text font-color-gray-darker'])[1]")).isDisplayed())) {
		    
		    pdp.clickOnWriteAReviewAtTop(driver);
		    logger.info("Clicked on Write a Review at the top");
		    pdp.clickOnRating(driver);
		    logger.info("Clicked on Rating");
		    pdp.clickOnReviewHeadline(driver, headline);
		    logger.info("Entered Review Headline");
		    pdp.clickOnComments(comment);
		    logger.info("Entered Comments");
		    pdp.clickOnYes();
		    logger.info("Clicked on Yes");
		    pdp.clicknickName(nickName);
		    logger.info("Entered Nickname");
		    pdp.clickOnLoc(location);
		    logger.info("Entered Location");
		    pdp.clickOnSubmitReview(driver);
		    logger.info("Clicked on Submit Review");
		    
		    // Add any additional steps for writing a review
		    validateReviewProduct();
		    
		    pdp.clickOncontinueShoping(driver);
		    logger.info("clicked on the clickOncontinueShoping button");
		}else {
			logger.info("Yopto reviews are activated");
			test.info("Yopto reviews are activated");			
			pdp.yoptpoReviews();
		}	    	    
	}

	private void validateReviewProduct() {
		
		test.info("validate the Review of the product");
		// Find the element using XPath
		WebElement thankYouText = driver.findElement(By.xpath("//div[@class='header col-sm-12']/h1[contains(text(), 'Thank you!')]"));
		// Get the text value of the element
		String actualText = thankYouText.getText();
		// Define the expected text
		String expectedText = "Thank you!";
		// Validate if the text is displayed using a basic if condition
		if (actualText.equals(expectedText)) {
		    logger.info("The 'Thank you!' text is displayed on the page.");
		    test.pass("successfully writen the review");
		} else {
		    logger.info("The 'Thank you!' text is not displayed on the page.");
		    test.fail("Review is not done");
		}

		
	}

}
package com.providio.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.providio.commonfunctionality.waitForTheElement;

public class miniCartPage {

    WebDriver lDriver;

    // Constructor for the miniCartPage class
    public miniCartPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    // Element for Cart Button
    @FindBy(xpath = "//a[contains(@class,'minicart-link')]")
    WebElement CartButton;

    // Method to click on the Cart Button
    public void clickcartbutton(WebDriver driver) throws InterruptedException {
        CartButton.click();
        Thread.sleep(2000);

        try {
            // Use JavaScript to click on the Cart Button (fallback)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", CartButton);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception or perform an alternative action if necessary
            CartButton.click();
        }
    }

    // Element for Cart Button (JavaScript click)
    @FindBy(xpath = "//a[@class='minicart-link']")
    WebElement CartButtonjs;

    // Method to click on the Cart Button using JavaScript
    public void clickcartbuttonjs(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //s.executeScript("arguments[0].click();", CartButton);
        CartButtonjs.click();
    }

    // Element for View Cart Button
    @FindBy(xpath = "//a[contains(@class,'btn  btn-block ')]")
    WebElement viewCartButton;

    // Method to click on the View Cart Button
    public void clickviewCartButton(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        viewCartButton.click();
        Thread.sleep(2000);
    }

    // Element for Checkout Button
    @FindBy(xpath = "//a[contains(@class,'btn btn-primary btn')]")
    WebElement Checkout;

    // Method to click on the Checkout Button
    public void clickCheckout() throws InterruptedException {
        Checkout.click();
        Thread.sleep(5000);
    }

    // Element for PayPal Button (Braintree Payment Integration)
    @FindBy(xpath = "//div[contains(@class,'js_braintree_paypal_cart_button')]")
    WebElement brainTreePaypalButton;

    // Method to click on the PayPal Button (Braintree Payment Integration)
    public void clickBrainTreePaypalButton(WebDriver driver) throws InterruptedException {
    	 Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
         WebElement  brainTreePaypalButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //div[contains(@class,'js_braintree_paypal_cart_button')]")));
    	  brainTreePaypalButton.click();
    	  Thread.sleep(5000);
    }

    // Element for PayPal Button (Salesforce Integration)
    @FindBy(xpath = "//div[contains(@class,'salesforce')]")
    WebElement salesforcePaypalButton;

    // Method to click on the PayPal Button (Salesforce Integration)
    public void clickSalesforcePaypalButton(WebDriver driver) {
    	Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
        WebElement salesforcePaypalButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'salesforce')]")));
        salesforcePaypalButton.click();
    }

    // Element for Google Pay Button (Salesforce)
    @FindBy(xpath = "//iframe[@title='Secure payment button frame']")
    WebElement googlePayButton;

    // Method to click on the Google Pay Button (Salesforce)
    public void clickOnGooglePayButton() {
        googlePayButton.click();
    }
}

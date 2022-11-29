package eletronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {

        //  1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
        //  1.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        Thread.sleep(2000);
        //   1.3 Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");


    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse Hover on “Electronics” Tab
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //  2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //  2.3 Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

        //  2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //  2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        // 2.6 Verify the text “Nokia Lumia 1020”
        assertVerifyText(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");

        //   2.7 Verify the price “$349.00”
        assertVerifyText(By.xpath("//span[@id='price-value-20']"), "$349.00");

        //   2.8 Change quantity to 2
        Actions actions = new Actions(driver);
        clickOnElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        //   2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //   2.10 Verify the Message "The product has been added to your shopping cart" on Top  green Bar
        assertVerifyText(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");

        //   After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //   2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));

        //   2.12 Verify the message "Shopping cart"
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //   2.13 Verify the quantity is 2
        //  assertVerifyText(By.xpath("//input[@id='itemquantity11298']"), "2");

        //    2.14 Verify the Total $698.00
        assertVerifyText(By.xpath("//span//strong[contains(text(),'$698.00')]"), "$698.00");

        //   2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //    2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //   2.17 Verify the Text “Welcome, Please Sign In!”
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        //    2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //    2.19 Verify the text “Register”
        assertVerifyText(By.xpath("//h1[contains(text(),'Register')]"), "Register");

        //    2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.id("FirstName"), "Anthony");
        sendTextToElement(By.id("LastName"), "Gonsalves");
        selectByVisibleTextFromDropdown(By.xpath("//select[@name='DateOfBirthDay']"), "1");
        selectByVisibleTextFromDropdown(By.xpath("//select[@name='DateOfBirthMonth']"), "January");
        selectByVisibleTextFromDropdown(By.xpath("//select[@name='DateOfBirthYear']"), "2000");
        sendTextToElement(By.id("Email"), "Xyzz@gmail.com");
        sendTextToElement(By.id("Password"), "1234567890");
        sendTextToElement(By.id("ConfirmPassword"), "1234567890");

        //   2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //   2.22 Verify the message “Your registration completed”
        assertVerifyText(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");

        //    2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //    2.24 Verify the text “Shopping card”
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        //    2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //   2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //    2.27 Fill the Mandatory fields
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "ABC");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_LastName"), "XYZ");
        Thread.sleep(1000);
        clickOnElement(By.id("BillingNewAddress_CountryId"));
        selectByVisibleTextFromDropdown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        Thread.sleep(1000);
        clickOnElement(By.id("BillingNewAddress_StateProvinceId"));
        selectByVisibleTextFromDropdown(By.id("BillingNewAddress_StateProvinceId"), "Other");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_Address1"), "420 Prem nagar");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "OO11 2BH");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "01234567890");

        //    2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text() = 'Continue']"));

        //    2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //    2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        //    2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));

        //    2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropdown(By.id("CreditCardType"), "Visa");


        //    2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Mr A Gonsalvies");
        sendTextToElement(By.id("CardNumber"), "1234 1234 1234 1234");
        selectByVisibleTextFromDropdown(By.id("ExpireMonth"), "06");
        selectByVisibleTextFromDropdown(By.id("ExpireYear"), "2026");
        sendTextToElement(By.id("CardCode"), "007");

        //    2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        //    2.35 Verify “Payment Method” is “Credit Card”
        assertVerifyText(By.xpath("//li[@class='payment-method']/span[2]"), "Credit Card");

        //    2.36 Verify “Shipping Method” is “2nd Day Air”
        assertVerifyText(By.xpath("//li[@class='shipping-method']/span[2]"), "2nd Day Air");

        //    2.37 Verify Total is “$698.00”
        assertVerifyText(By.xpath("//td[@class='subtotal']/span"), "$698.00");

        //    2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[text()='Confirm']"));

        //    2.39 Verify the Text “Thank You”
        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //    2.40 Verify the message “Your order has been successfully processed!”
        assertVerifyText(By.xpath("//div[@class='section order-completed']//strong"), "Your order has been successfully processed!");

        //    2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //    2.42 Verify the text “Welcome to our store”
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

        //    2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        // 2.44 Verify the URL is “https://demo.nopcommerce.com/"
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/", url);


    }

    @After
    public void tearDown() {

        closeBrowser();
    }

}

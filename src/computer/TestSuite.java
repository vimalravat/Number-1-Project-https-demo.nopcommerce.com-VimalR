package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        // Click on Computer Menu.
        clickOnElement(By.xpath("//a[contains(text(),'Computers ')]"));
        // Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        // Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//select[@id='products-orderby']"));

        selectByVisibleTextFromDropdown(By.id("products-orderby"), "Name: Z to A");
        // Verify the Product will arrange in Descending order.


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // Click on Computer Menu.
        clickOnElement(By.xpath("//a[contains(text(),'Computers ')]"));
        // Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        // Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        WebElement dropDown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name: A to Z");
        // Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']"));
        // Verify the Text "Build your own computer"
        String expectMessage = "Build your own computer";
        //Find the welcome text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        String actualMessage = actualTextMessageElement.getText();
        //   Validate actual and expected message
        Assert.assertEquals("No such message found", expectMessage, actualMessage);

        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropdown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class.
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_2"));
        selectByVisibleTextFromDropdown(By.id("product_attribute_2"), "8GB [+$60.00]");
        // Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_3_7"));
        sendTextToElement(By.id("product_attribute_3_7"), "400 GB [+$100.00]");
        // Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_4_9"));
        sendTextToElement(By.id("product_attribute_4_9"), "Vista Premium [+$60.00]");
        // Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_5_12"));
        // Verify the price "$1,475.00"
        String expectedAmount = "$1,475.00";
        String actualAmount = getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]"));
        Assert.assertEquals("Text is not present", expectedAmount, actualAmount);
        // Click on "ADD TO CARD" Button.
        Thread.sleep(1000);
        clickOnElement(By.xpath(" //button[@id='add-to-cart-button-1']"));

        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectMessage2 = "The product has been added to your shopping cart";
        String actualMessage2 = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Text is not present", expectMessage2, actualMessage2);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"));

        // Verify the message "Shopping cart"
        String expectMessage3 = "Shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Text is not present", expectMessage3, actualMessage3);


        // Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.xpath("//input[@class='qty-input']"));
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));


        assertVerifyText(By.xpath("//span//strong[contains(text(),'$2,950.00')]"), "$2,950.00");

        // click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        // Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        // Verify the Text “Welcome, Please Sign In!”
        String expectedAmount5 = "Welcome, Please Sign In!";
        String actualAmount5 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Message is not present", expectedAmount5, actualAmount5);

        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        // Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "ABC");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_LastName"), "XYZ");
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_Email"), "Abc1234@gmail.com");
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
        Thread.sleep(1000);

        // Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        // Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //  2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='ShippingMethod.save()']"));

        //  2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@type='button' and @onclick='PaymentMethod.save()']"));

        //  2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.id("CreditCardType"));
        selectByVisibleTextFromDropdown(By.id("CreditCardType"), "Master card");

        //  2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "MR I M Sad");
        sendTextToElement(By.id("CardNumber"), "0110 1231 1456 0110");

        clickOnElement(By.id("ExpireMonth"));
        selectByVisibleTextFromDropdown(By.id("ExpireMonth"), "06");

        clickOnElement(By.id("ExpireYear"));
        selectByVisibleTextFromDropdown(By.id("ExpireYear"), "2024");

        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");

        //  2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='PaymentInfo.save()']"));

        //  2.30 Verify “Payment Method” is “Credit Card”
        assertVerifyText(By.xpath("//span[contains(text(),'Payment Method:')]"), "Payment Method:");
        assertVerifyText(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");

        //  2.31 Verify “Shipping Method” is “Next Day Air”
        assertVerifyText(By.xpath("//span[contains(text(),'Shipping Method:')]"), "Shipping Method:");
        assertVerifyText(By.xpath("//ul//li//span[contains(text(),'Next Day Air')]"), "Next Day Air");

        //	2.32 Verify Total is “$2,950.00”
        assertVerifyText(By.xpath("//span//strong[contains(text(),'$2,950.00')]"), "$2,950.00");

        //	2.33 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='ConfirmOrder.save()']"));

        //	2.34 Verify the Text “Thank You”
        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //	2.35 Verify the message “Your order has been successfully processed!”
        assertVerifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),
                "Your order has been successfully processed!");

        //	2.36 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@type='button' and @onclick='setLocation(\"/\")']"));

        //  2.37 Verify the text “Welcome to our store”
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}

package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    public void sendTextToElements(By by, String text) {
        WebElement emailField = driver.findElement(by);
        emailField.sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
        //This method verify the expected text
    }
        public void assertVerifyText(By by, String expectedtext) {
            String actualText = getTextFromElement(by);
            String expectedText = expectedtext;
            Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText, actualText);

    }

    //****************** Alert Methods********************
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    // Homework 4 method
    public void acceptAlert() {
        driver.switchTo().alert().getText();

    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();

    }

    public void sentTextToAlert(String Text) {
        driver.switchTo().alert().sendKeys(Text);

    }

    //********************* Select Class Methods*********************

    /**
     *
     *
     */
    public void selectByVisibleTextFromDropdown(By by, String text){
        WebElement dropDown= driver.findElement(by);
        Select select = new Select(dropDown);
        select .selectByVisibleText(text);


    }

    public void selectByValueFromDropdown(By by, String text){
        WebElement dropDown= driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);


    }
    public void selectByIndexFromDropdown(By by, int index){
        WebElement dropDown= driver.findElement(by);
        Select select = new Select(dropDown);
        select .selectByIndex(index);


}

 public void selectByGetContainsDropdown(By by, String text){
        WebElement dropDown= driver.findElement(by);
        Select select = new Select(dropDown);
             selectByGetContainsDropdown(by, text);


}

    // *******Window Handle*******
    //***************************Action Class********************
    public void mouseHoverToElement (By by){
        Actions actions = new Actions(driver);
        WebElement mouseHover= driver.findElement(by);
        actions.moveToElement(mouseHover).build().perform();

    }
    public void mouseHoverToElementAndClick(By by){
        Actions actions = new Actions(driver);
        WebElement mouseHoveAndClick = driver.findElement(by);
        actions.moveToElement(mouseHoveAndClick).click().build().perform();
    }
}

package LetCodeActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class LetCodeActions {

    public void actionSendKeys(WebElement element, Object text) {
        element.sendKeys(text.toString());
    }


    public void actionClick(WebElement element) {
        element.click();
    }

    public void actionClear(WebElement element) {
        element.clear();
    }

    public String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }
    //make hover method
     public void actionHover(WebElement element, WebDriver driver) {
         Actions action = new Actions(driver);

         action.moveToElement(element).perform();
         SoftAssert softAssert = new SoftAssert();
         softAssert.assertTrue(element.isDisplayed(), "Element is not displayed after hover");
         softAssert.assertAll("Hover action failed");
     }

}

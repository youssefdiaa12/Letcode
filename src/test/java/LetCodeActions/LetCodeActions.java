package LetCodeActions;

import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

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

    //explict wait
    public void explicitWait(WebDriver driver, int time, ExpectedCondition<?> condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(condition);
    }

    public Point getLocation(WebElement element) {
        return element.getLocation();
    }

    public String getColor(WebElement element, String cssProperty) {
        return element.getCssValue(cssProperty);
    }
    public Rectangle getRectangle(WebElement element) {
        return element.getRect();
    }
    public String actionHoldData(WebElement element, WebDriver driver) {
        Actions action = new Actions(driver);
        action.clickAndHold(element).pause(Duration.ofSeconds(5)).release().build().perform();
        return  element.getText();
    }
    public Select getSelect(WebElement element) {
        return new Select(element);
    }
}


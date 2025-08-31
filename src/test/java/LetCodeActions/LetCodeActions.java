package LetCodeActions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LetCodeActions {
    protected Actions action;

    public LetCodeActions(WebDriver driver) {
        action = new Actions(driver);
    }

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
    public boolean actionHover(WebElement element, WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        return element.isDisplayed();
    }

    //explict wait

    public WebElement explicitWait(WebDriver driver, int time, ExpectedCondition<WebElement> condition) {
        return new WebDriverWait(driver, Duration.ofSeconds(time)).until(condition);
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        action.clickAndHold(element).pause(Duration.ofSeconds(5)).build().perform();
        String text = element.getText();
        action.release(element).perform();
        return text;
    }


    public void actionUploadFile(WebElement element, String filePath) {
        element.sendKeys(filePath);
    }

    public Select getSelect(WebElement element) {
        return new Select(element);
    }

    public void dragAndDrop(WebElement source) {


//            action.moveToElement(source)
//                    .clickAndHold()
//                    .moveByOffset(x-15, y-15)   // smaller offsets in a loop work better
//                    .pause(Duration.ofMillis(400))
//                    .release()
//                    .perform();

        action.moveToElement(source)
                .clickAndHold()
                .moveByOffset(50, 30)   // try small offsets inside the container
                .pause(Duration.ofMillis(300))
                .release()              // VERY IMPORTANT
                .perform();
    }
}


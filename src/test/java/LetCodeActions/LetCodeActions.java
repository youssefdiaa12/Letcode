package LetCodeActions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class LetCodeActions {
    protected Actions action;
    protected Alert alert;

    public LetCodeActions(WebDriver driver) {
        action = new Actions(driver);
    }

    public void actionSendKeys(WebElement element, Object text) {
        element.sendKeys(text.toString());
    }

    public void actionClick(WebElement element) {
        element.click();
    }

    // Create a helper method for alerts
    public Alert getAlert(WebDriver driver) {
        try {
            return driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            return null;
        }
    }
    public void RemoveIframe(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll('iframe[id^=\"aswift_\"]').forEach(e => e.remove());");
        // Remove divs that start with "aswift_"
        js.executeScript("document.querySelectorAll('div[id^=\"aswift_\"]').forEach(e => e.remove());");
        js.executeScript("document.querySelectorAll('ins.adsbygoogle').forEach(e => e.remove());");

    }
    public void closeDynamicPopupIfExists(WebDriver driver) {
        try {
            // Switch to the iframe if it exists
            List<WebElement> frames = driver.findElements(By.tagName("iframe"));
            for (WebElement frame : frames) {
                driver.switchTo().frame(frame);
                // Try to find the close button inside
                List<WebElement> closeButtons = driver.findElements(By.xpath("//button[contains(text(),'×') or @class='close']"));
                if (!closeButtons.isEmpty()) {
                    closeButtons.get(0).click();
                    System.out.println("Popup closed.");
                    driver.switchTo().defaultContent();
                    return;
                }
                driver.switchTo().defaultContent();
            }
        } catch (Exception e) {
            System.out.println("No popup found, continuing...");
        }
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
    public void actionScrollToElement(WebElement element, WebDriver driver) {
        action.moveToElement(element).perform();
    }
    public void actionIDFrame() {
      alert.dismiss();
    }
}


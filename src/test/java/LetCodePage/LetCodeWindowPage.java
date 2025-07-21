package LetCodePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LetCodeWindowPage {




    public WebElement OpenHomePage(WebDriver driver) {
        return driver.findElement(By.cssSelector("button.button.is-info"));
    }
}

package LetCodePage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LetCodeButtonPage {


    public WebElement GotoButton(WebDriver driver) {
        return driver.findElement(By.id("home"));
    }

    public WebElement FindLocation(WebDriver driver) {
        return driver.findElement(By.id("position"));
    }

    public WebElement FindColor(WebDriver driver) {
        return driver.findElement(By.id("color"));
    }

    public WebElement HeightWidthButton(WebDriver driver) {
        return driver.findElement(By.id("property"));
    }

    public WebElement ISDisabled(WebDriver driver) {
        return driver.findElement(By.id("isDisabled"));
    }

    public WebElement ButtonHold(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"isDisabled\"]/div/h2"));
    }
}

package LetCodePage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LetCodeDropDownPage {


    public WebElement SelectFruit(WebDriver driver) {
        return driver.findElement(By.cssSelector("#fruits"));
    }

    public WebElement SelectSuperHeroes(WebDriver driver) {
        return driver.findElement(By.id("superheroes"));
    }

    public WebElement SelectLanguage(WebDriver driver) {
        return driver.findElement(By.id("lang"));
    }

    public WebElement SelectCountry(WebDriver driver) {
        return driver.findElement(By.id("country"));
    }

    public WebElement SelectSubTitle(WebDriver driver, ExpectedCondition<?> condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(condition);
        return driver.findElement(By.className("subtitle"));
    }
    public String SelectColor(WebDriver driver) {
        return driver.findElement(By.className("notification")).getCssValue("background-color");
    }

}

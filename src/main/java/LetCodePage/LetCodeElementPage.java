package LetCodePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LetCodeElementPage {


    public WebElement getEnterYourName(WebDriver driver) {

        return driver.findElement(By.cssSelector("p.control.is-expanded > input[name='username']"));
    }
    public WebElement getSearch(WebDriver driver) {

        return driver.findElement(By.cssSelector("p.control> button[id='search']"));
    }
    public List<WebElement> getLabels(WebDriver driver) {

        return driver.findElements(By.tagName("label"));
    }

}
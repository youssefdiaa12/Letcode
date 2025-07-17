package LetCodePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LetCodeHomePage  {
  public   WebElement returnPageObject(WebDriver driver1) {
        return driver1.findElement(By.linkText("Page Object Model"));
    }
}
package LetCodePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LetCodeAlertPage {

    public  WebElement SimpleAlert(WebDriver driver) {
         return driver.findElement(By.id("accept"));
    }

    public  WebElement ConfirmAlert(WebDriver driver) {
        return driver.findElement(By.id("confirm"));
    }
    public  WebElement PromptAlert(WebDriver driver) {
       return driver.findElement(By.id("prompt"));
       //test github action
    }
    public  WebElement ModernAlert(WebDriver driver) {
        return driver.findElement(By.id("modern"));
    }

}

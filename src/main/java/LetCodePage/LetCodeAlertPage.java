package LetCodePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LetCodeAlertPage {
    private static WebElement webElement;



    public  WebElement SimpleAlert(WebDriver driver) {
         return driver.findElement(By.id("accept"));
    }

    public  WebElement ConfirmAlert(WebDriver driver) {
        return driver.findElement(By.id("confirm"));
    }
    public  WebElement PromptAlert(WebDriver driver) {
       return driver.findElement(By.id("prompt"));

    }
    public  WebElement ModernAlert(WebDriver driver) {
        return driver.findElement(By.id("modern"));
    }

}

package LetCodePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LetCodeFramePage {
    private static WebElement webElement;



    public  WebElement FirstName(WebDriver driver) {
         return driver.findElement(By.cssSelector("input[name='fname']"));
    }

    public  WebElement LastName(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[name='lname']"));
    }

    public  WebElement Email(WebDriver driver) {
        return driver.findElement(By.name("email"));
    }

}

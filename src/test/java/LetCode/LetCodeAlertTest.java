package LetCode;

import LetCodeActions.LetCodeActions;
import LetCodePage.LetCodeAlertPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
@Test(groups = {"LetCode"})

public class LetCodeAlertTest extends Driver {
    protected WebElement webElement;
    protected LetCodeAlertPage letCodeAlertPage;
    protected LetCodeActions letCodeActions ;

    @BeforeClass
    public void setUp() throws InterruptedException {
        // Initialize LetCodeAlertPage and LetCodeActions
        letCodeAlertPage = new LetCodeAlertPage();
        letCodeActions = new LetCodeActions();
        super.setUp();
        super.navigateTo("https://letcode.in/alert");
        // Wait for the page to load and elements to be visible
        Thread.sleep(2000);
    }

    @Test(priority = 1, description = "Test LetCode DropDowns",groups = {"smoke"})
    public void TestConfirmAlert() {
        webElement = letCodeAlertPage.SimpleAlert(driver1);
        letCodeActions.actionClick(webElement);
        Alert alert = driver1.switchTo().alert();
        String text = alert.getText();
        softAssert.assertEquals(text, "Hey! Welcome to LetCode", "Alert text does not match");
        alert.accept();
    }

    @Test(priority = 2, description = "Test LetCode Prompt Alert")
    public void TestPromptAlert() {
        webElement = letCodeAlertPage.PromptAlert(driver1);
        letCodeActions.actionClick(webElement);
        Alert alert = driver1.switchTo().alert();
        //check if alert is displayed
        softAssert.assertTrue(alert.getText().contains("Enter your name"), "Alert text does not match");
        alert.sendKeys("Koushik");
        alert.accept();


    }

    @Test(priority = 3, description = "Test LetCode Modern Alert")
    public void TestModernAlert() {
        webElement = letCodeAlertPage.ModernAlert(driver1);
        letCodeActions.actionClick(webElement);

//use SweetAlert to handle this alert
        WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
        webElement = wait.until(ExpectedConditions.visibilityOf(
                driver1.findElement(By.cssSelector(".modal-content .title"))));
        softAssert.assertEquals(webElement.getText(), "Modern Alert - Some people address me as sweet alert as well", "Modern alert text does not match");

        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.modal-close.is-large")
        ));
        closeButton.click();
    }

    @Test(priority = 4, description = "Assert All")
    public void assertAll() {
        softAssert.assertAll("There are some errors in the test");
    }

}

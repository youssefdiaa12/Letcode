package LetCode;

import LetCodePage.LetCodeElementPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LetCodeElementTest extends Driver {
    protected LetCodeElementPage letCodeElementPage;
    protected WebElement webElement;

    @BeforeClass
    @Parameters({"Browser", "URL"})
    public void setUp(String Browser, String URL) throws InterruptedException {
        super.setUp(Browser,URL);
        letCodeElementPage = new LetCodeElementPage();
        navigateTo("https://letcode.in/elements");
    }

    @Test(priority = 1, description = "Test LetCode Element")
    public void testLetElements() throws InterruptedException {
        webElement = letCodeElementPage.getEnterYourName(driver1);
        letCodeActions.actionSendKeys(webElement, "ortonikc");
        Thread.sleep(2000);
        softAssert.assertEquals(webElement.getAttribute("value"), "dada");
        webElement = letCodeElementPage.getSearch(driver1);
        letCodeActions.actionClick(webElement);
    }
    @Test(priority = 2, description = "Test LetCode Element")
    public void testLabels() throws InterruptedException {
        webElement = letCodeElementPage.getEnterYourName(driver1);

    }
    //make soft assert all
    @Test(priority = 2, description = "make soft assert all")
    public void makeSoftAssertAll() {
        System.out.println("makeSoftAssertAll");
        softAssert.assertAll();
    }
}

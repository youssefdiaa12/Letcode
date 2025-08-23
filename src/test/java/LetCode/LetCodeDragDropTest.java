package LetCode;

import LetCodePage.LetCodeDragDropPage;
import LetCodePage.LetCodeElementPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LetCodeDragDropTest extends Driver {
    protected LetCodeDragDropPage letCodeDragDropPage;
    protected WebElement webElement;

    @BeforeClass
    @Parameters({"Browser", "URL"})
    public void setUp(String Browser, String URL) throws InterruptedException {
        super.setUp(Browser, URL);
        letCodeDragDropPage = new LetCodeDragDropPage();
        navigateTo("https://letcode.in/draggable");
    }

    @Test(priority = 1, description = "Test LetCode drag drop element founded")
    public void testLetElements() throws InterruptedException {
        //wait until element found using explicit wait
        ExpectedCondition condition = ExpectedConditions.visibilityOf(letCodeDragDropPage.getDraggable(driver1));
        webElement = letCodeActions.explicitWait(driver1, 10, condition);
        boolean isDisplayed = webElement.isDisplayed();
        softAssert.assertTrue(isDisplayed);
        if (isDisplayed) {
            int x = webElement.getLocation().getX();
            int y = webElement.getLocation().getY();
            System.out.println(x + "  ---------  " + y);
            letCodeActions.dragAndDrop(webElement);
            webElement = letCodeActions.explicitWait(driver1, 10, condition);
            System.out.println(webElement.getLocation().getX() + "  ---------  " + webElement.getLocation().getY());
        }
    }


    //make soft assert all
    @Test(priority = 2, description = "make soft assert all")
    public void makeSoftAssertAll() {
        System.out.println("makeSoftAssertAll");
        softAssert.assertAll();
    }
}

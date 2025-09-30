package LetCode;

import LetCodePage.LetCodeFilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class LetCodeFileTest extends Driver {
    protected LetCodeFilePage letCodeFilePage;
    protected WebElement webElement;
    protected SoftAssert softAssert1;

    @Parameters({"Browser", "URL"})
    @BeforeClass
    public void setUp(String Browser, String URL) throws InterruptedException {
        super.setUp(Browser, URL);
        letCodeFilePage = new LetCodeFilePage();
        navigateTo("https://letcode.in/file");
       softAssert1 = new SoftAssert();
    }
    @Test(priority = 1, description = "Test LetCode Upload File Button")
    public void testLetCodeUploadFileButton() {
        webElement = letCodeFilePage.fileInputUpload(driver1);
        letCodeActions.actionUploadFile(webElement, "C:\\Users\\ysoltan\\Downloads\\test.txt");
        //check that the webElement is uploaded
        softAssert1.assertTrue(webElement.isDisplayed());
    }

    @Test(priority = 2, description = "Test LetCode Download File Button")
    public void testLetCodeDownloadFileButton() throws InterruptedException {
        webElement = letCodeFilePage.fileDownloadButton(driver1);
        letCodeActions.actionClick(webElement);

// Now click your element
        webElement = letCodeFilePage.XLS(driver1);
        // check if element is displayed
        if (webElement.isDisplayed()) {
            //letCodeActions.actionClick(webElement);
            letCodeActions.RemoveIframe(driver1);
        }
        //check that the webElement is downloaded
        softAssert1.assertTrue(webElement.isDisplayed());
    }

    @Test(priority = 3, description = "Test LetCode Download File Button by Link Text")
    public void testLetCodeDownloadFileButtonByLinkText() throws InterruptedException {
        webElement = letCodeFilePage.XLS(driver1);
        // check if element is displayed
        if (webElement.isDisplayed()) {
            //letCodeActions.actionClick(webElement);
            letCodeActions.RemoveIframe(driver1);
        }
        webElement = letCodeFilePage.fileDownloadButtonByLinkText(wait);
        letCodeActions.actionClick(webElement);
        softAssert1.assertTrue(webElement.isDisplayed());
    }
    //make soft assert all
    // @AfterClass
    @AfterClass(alwaysRun = true,description = "Make soft assert all")
    public void makeSoftAssertAll() {
        softAssert1.assertAll();
    }
}

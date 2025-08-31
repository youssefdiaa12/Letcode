package LetCode;

import LetCodePage.LetCodeFilePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LetCodeFileTest extends Driver {
    protected LetCodeFilePage letCodeFilePage;
    protected WebElement webElement;

    @Parameters({"Browser", "URL"})
    @BeforeClass
    public void setUp(String Browser, String URL) throws InterruptedException {
        super.setUp(Browser, URL);
        letCodeFilePage = new LetCodeFilePage();
        navigateTo("https://letcode.in/file");
    }

    @Test(priority = 1, description = "Test LetCode Upload File Button")
    public void testLetCodeRadio() {
        webElement = letCodeFilePage.fileInputUpload(driver1);
        letCodeActions.actionUploadFile(webElement, "C:\\Users\\ysoltan\\Downloads\\test.txt");
        //check that the webElement is uploaded
        softAssert.assertTrue(webElement.isDisplayed());
    }

    @Test(priority = 2, description = "Test LetCode Download File Button")
    public void testLetCodeDownloadFileButton() {
        webElement = letCodeFilePage.fileDownloadButton(driver1);
        letCodeActions.actionClick(webElement);
        //check that the webElement is downloaded
        softAssert.assertTrue(webElement.isDisplayed());
    }

    @Test(priority = 3, description = "Test LetCode Download File Button by Link Text")
    public void testLetCodeDownloadFileButtonByLinkText() {
        webElement = letCodeFilePage.fileDownloadButtonByLinkText(driver1);
        letCodeActions.actionClick(webElement);
        //check that the webElement is downloaded
        softAssert.assertTrue(webElement.isDisplayed());
    }


    //make soft assert all
    @Test(priority = 5, description = "make soft assert all")
    public void makeSoftAssertAll() {
        softAssert.assertAll();
    }
}

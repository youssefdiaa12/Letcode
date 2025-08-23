package LetCode;

import LetCodeActions.LetCodeActions;
import LetCodePage.LetCodeHomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LetCodeHomeTest extends Driver {
    protected LetCodeHomePage letCodePageMain;

    @BeforeClass(description = "Navigate to LetCode Home Page")
    @Parameters({"Browser", "URL"})
    public void testLetCodeHomePage(String Browser, String URL) throws InterruptedException {
        super.setUp(Browser,URL);
        navigateTo(URL);
        letCodePageMain = new LetCodeHomePage();
    }

    @Test
    public void testLetCodePage() {
        WebElement webElement = letCodePageMain.returnPageObject(driver1);
        letCodeActions.actionClick(webElement);
    }
}

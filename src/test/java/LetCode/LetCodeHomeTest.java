package LetCode;

import LetCodeActions.LetCodeActions;
import LetCodePage.LetCodeHomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LetCodeHomeTest extends Driver {
    protected LetCodeHomePage letCodePageMain= new LetCodeHomePage();

    @BeforeClass(description = "Navigate to LetCode Home Page")
    public void testLetCodeHomePage() throws InterruptedException {
        super.setUp();
        navigateTo("https://letcode.in/test");
    }

    @Test
    public void testLetCodePage() {
        WebElement webElement = letCodePageMain.returnPageObject(driver1);
        letCodeActions.actionClick(webElement);
    }
}

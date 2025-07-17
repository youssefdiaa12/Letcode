package LetCode;

import LetCodeActions.LetCodeActions;
import LetCodePage.LetCodeHomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LetCodeHomeTest extends Driver {
    protected LetCodeHomePage letCodePageMain= new LetCodeHomePage();
    protected LetCodeActions letCodeActions= new LetCodeActions();

    @Test(priority = 1, description = "Navigate to LetCode Home Page")
    public void testLetCodeHomePage() {
        navigateTo("https://letcode.in/");
    }

    @Test
    public void testLetCodePage() {
        WebElement webElement = letCodePageMain.returnPageObject(driver1);
        letCodeActions.actionClick(webElement);
    }
}

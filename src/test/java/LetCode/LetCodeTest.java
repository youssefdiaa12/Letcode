package LetCode;

import LetCodePage.LetCodePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import LetCodeActions.LetCodeActions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
@Parameters("Browser")
public class LetCodeTest extends Driver {

    @Test(priority = 1,description = "Test LetCode Page")
    public void testLetCodeEditPage()  {
        LetCodePage letCodePage = new LetCodePage(driver1);
        letCodeActions.actionSendKeys(letCodePage.getFullName(), "ortonikc");

        letCodeActions.actionSendKeys(letCodePage.getJoin(), Keys.TAB);
        letCodeActions.actionSendKeys(letCodePage.getJoin(), "TEST");
        Assert.assertTrue(letCodeActions.getAttribute(letCodePage.getJoin(), "value").contains("TEST"), "The value should be Test");
        letCodeActions.actionClick(letCodePage.getGetMe());

        Assert.assertTrue(letCodePage.getNoEdit().getAttribute("value").isEmpty(), "The value should be empty");
        boolean enabled = letCodePage.getNoEdit().isEnabled();
        //wait for three seconds without using thread.sleep
        WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(3));
        wait.until(webDriver -> driver1.getTitle().equals("Edit Fields | LetCode with Koushik"));
        Assert.assertEquals(driver1.getTitle(), "Edit Fields | LetCode with Koushik", "The title should be 'LetCode - Edit'");
        System.out.println(enabled);
        Assert.assertFalse(enabled, "The button should not be enabled");
        letCodeActions.actionClick(letCodePage.getWorkSpace());
    }


//    @Test(priority = 1,description = "Test LetCode Page1",groups = {"regression"})
//    public void testLetCodeEditPage1() throws InterruptedException {
//        LetCodePage letCodePage = new LetCodePage(driver1);
//        LetCodeActions letCodeActions = new LetCodeActions();
//        letCodeActions.actionSendKeys(letCodePage.getFullName(), "ortonikc");
//
//        letCodeActions.actionSendKeys(letCodePage.getJoin(), Keys.TAB);
//        letCodeActions.actionSendKeys(letCodePage.getJoin(), "TEST");
//        Assert.assertTrue(letCodeActions.getAttribute(letCodePage.getJoin(), "value").contains("TEST"), "The value should be Test");
//        letCodeActions.actionClick(letCodePage.getGetMe());
//
//        Assert.assertTrue(letCodePage.getNoEdit().getAttribute("value").isEmpty(), "The value should be empty");
//        boolean enabled = letCodePage.getNoEdit().isEnabled();
//        //verify that the window title is "LetCode - Edit"
//        Assert.assertEquals(driver1.getTitle(), "LetCode - Edit", "The title should be 'LetCode - Edit'");
//        System.out.println(enabled);
//        Assert.assertFalse(enabled, "The button should not be enabled");
//        letCodeActions.actionClick(letCodePage.getWorkSpace());
//    }
}

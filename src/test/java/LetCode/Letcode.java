package LetCode;

import LetCodePage.LetCodePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import LetCodeActions.LetCodeActions;
import org.testng.annotations.Test;

@Test(groups = {"LetCode"})
public class Letcode extends Driver {


    @Test(priority = 1,description = "Test LetCode Page",groups = {"smoke"})
    public void testLetCodeEditPage() throws InterruptedException {
        LetCodePage letCodePage = new LetCodePage(driver1);
        LetCodeActions letCodeActions = new LetCodeActions();
        letCodeActions.actionSendKeys(letCodePage.getFullName(), "ortonikc");

        letCodeActions.actionSendKeys(letCodePage.getJoin(), Keys.TAB);
        letCodeActions.actionSendKeys(letCodePage.getJoin(), "TEST");
        Assert.assertTrue(letCodeActions.getAttribute(letCodePage.getJoin(), "value").contains("TEST"), "The value should be Test");
        letCodeActions.actionClick(letCodePage.getGetMe());

        Assert.assertTrue(letCodePage.getNoEdit().getAttribute("value").isEmpty(), "The value should be empty");
        boolean enabled = letCodePage.getNoEdit().isEnabled();
        //verify that the window title is "LetCode - Edit"
        Assert.assertEquals(driver1.getTitle(), "LetCode - Edit", "The title should be 'LetCode - Edit'");
        System.out.println(enabled);
        Assert.assertFalse(enabled, "The button should not be enabled");
        letCodeActions.actionClick(letCodePage.getWorkSpace());
    }


    @Test(priority = 1,description = "Test LetCode Page1",groups = {"regression"})
    public void testLetCodeEditPage1() throws InterruptedException {
        LetCodePage letCodePage = new LetCodePage(driver1);
        LetCodeActions letCodeActions = new LetCodeActions();
        letCodeActions.actionSendKeys(letCodePage.getFullName(), "ortonikc");

        letCodeActions.actionSendKeys(letCodePage.getJoin(), Keys.TAB);
        letCodeActions.actionSendKeys(letCodePage.getJoin(), "TEST");
        Assert.assertTrue(letCodeActions.getAttribute(letCodePage.getJoin(), "value").contains("TEST"), "The value should be Test");
        letCodeActions.actionClick(letCodePage.getGetMe());

        Assert.assertTrue(letCodePage.getNoEdit().getAttribute("value").isEmpty(), "The value should be empty");
        boolean enabled = letCodePage.getNoEdit().isEnabled();
        //verify that the window title is "LetCode - Edit"
        Assert.assertEquals(driver1.getTitle(), "LetCode - Edit", "The title should be 'LetCode - Edit'");
        System.out.println(enabled);
        Assert.assertFalse(enabled, "The button should not be enabled");
        letCodeActions.actionClick(letCodePage.getWorkSpace());
    }
}

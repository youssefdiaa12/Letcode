package LetCode;

import LetCodePage.LetCodeRadioPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LetCodeRadioTest extends Driver {
    protected LetCodeRadioPage letCodeRadioPage = new LetCodeRadioPage();
    protected WebElement webElement;

    @BeforeClass
    public void setUp() {
        navigateTo("https://letcode.in/radio");
    }

    @Test(priority = 1, description = "Test LetCode Radio Button")
    public void testLetCodeRadio() throws InterruptedException {
        webElement = letCodeRadioPage.getRadio(driver1, "yes");
        letCodeActions.actionClick(webElement);
        boolean isSelected = letCodeRadioPage.isRadioSelected(driver1, "yes");
        softAssert.assertTrue(isSelected, "The radio button yes should be selected");
        Thread.sleep(2000);
    }

    @Test(priority = 2, description = "Test LetCode Radio Button No")
    public void testLetCodeRadioNo() {
         letCodeRadioPage.getRadio(driver1, "no");
        letCodeActions.actionClick(webElement);
        boolean isSelected = letCodeRadioPage.isRadioSelected(driver1, "no");
        softAssert.assertTrue(isSelected, "The radio button no should be selected");
    }

    @Test(priority = 3, description = "Test LetCode Radio Button Maybe")
    public void testLetCodeRadioMaybe() {
        webElement = letCodeRadioPage.getRadio(driver1, "maybe");
        letCodeActions.actionClick(webElement);
        boolean isEnabled = letCodeRadioPage.isRadioEnabled(driver1, "maybe");
        softAssert.assertTrue(!isEnabled, "The radio button should not be enabled");
    }

    @Test(priority = 4, description = "Test LetCode Radio Button Remember Me Checkbox")
    public void testLetCodeRadioClickCheckBox() throws InterruptedException {
       letCodeRadioPage.clickCheckBox(driver1, "label.checkbox");

       Thread.sleep(2000);
        boolean isSelected = letCodeRadioPage.isCheckBoxSelected(driver1, "label.checkbox");
        // Assert that the checkbox is selected
        softAssert.assertTrue(isSelected, "The checkbox should be selected");
    }


    //make soft assert all
    @Test(priority = 5, description = "make soft assert all")
    public void makeSoftAssertAll() {
        softAssert.assertAll();
    }
}

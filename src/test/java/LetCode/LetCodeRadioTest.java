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
        navigateTo("https://letcode.in/radio-buttons");
        letCodeActions.actionClick(webElement);
    }

    @Test(priority = 1, description = "Test LetCode Radio Button")
    public void testLetCodeRadio() {
        webElement = letCodeRadioPage.getRadio(driver1, "yes");
        letCodeActions.actionClick(webElement);
        boolean isSelected = letCodeRadioPage.isRadioSelected(driver1, "yes");
        softAssert.assertTrue(isSelected, "The radio button should be selected");
    }

    @Test(priority = 2, description = "Test LetCode Radio Button No")
    public void testLetCodeRadioNo() {
         letCodeRadioPage.clickCheckBox(driver1, "no");
        //letCodeActions.actionClick(webElement);
        boolean isSelected = letCodeRadioPage.isRadioSelected(driver1, "no");
        softAssert.assertTrue(isSelected, "The radio button should be selected");
    }

    @Test(priority = 3, description = "Test LetCode Radio Button Maybe")
    public void testLetCodeRadioMaybe() {
        webElement = letCodeRadioPage.getRadio(driver1, "maybe");
        letCodeActions.actionClick(webElement);
        boolean isEnabled = letCodeRadioPage.isRadioEnabled(driver1, "maybe");
        softAssert.assertTrue(!isEnabled, "The radio button should not be enabled");
    }

    //make soft assert all
    @Test(priority = 4, description = "make soft assert all")
    public void makeSoftAssertAll() {
        softAssert.assertAll();
    }
}

package LetCode;

import LetCodeActions.LetCodeActions;
import LetCodePage.LetCodeDropDownPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LetCodeDropDownsTest extends Driver {
    protected WebElement webElement;
    protected LetCodeDropDownPage letCodeButtonPage = new LetCodeDropDownPage();
    protected LetCodeActions letCodeActions = new LetCodeActions();

    @BeforeClass
    public void setUp() {
        navigateTo("https://letcode.in/dropdowns");
    }

    @Test(priority = 1, description = "Test LetCode DropDowns")
    public void testLetCodeDropDowns() throws InterruptedException {
        webElement = letCodeButtonPage.SelectFruit(driver1);
        Select select = letCodeActions.getSelect(webElement);
        select.selectByVisibleText("Apple");
        WebElement selectedOption = select.getFirstSelectedOption();
        select.isMultiple();
        softAssert.assertEquals(selectedOption.getText(), "Apple", "Selected fruit does not match");
        webElement = letCodeButtonPage.SelectSubTitle(driver1,
                ExpectedConditions.visibilityOfElementLocated(By.className("subtitle")));
        softAssert.assertEquals(webElement.getText(), "You have selected Apple", "Subtitle text does not match");
        String color = letCodeButtonPage.SelectColor(driver1);
        softAssert.assertEquals(color, "rgba(22, 197, 127, 1)", "Color does not match");
    }



}

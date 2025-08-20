package LetCode;

import LetCodeActions.LetCodeActions;
import LetCodePage.LetCodeButtonPage;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LetCodeButtonTest extends Driver {
    protected WebElement webElement;
    protected LetCodeButtonPage letCodeButtonPage = new LetCodeButtonPage();

    @BeforeClass
    public void testLetCodeButtonPage()  {
        navigateTo("https://letcode.in/button");
    }


    @Test(priority = 3, description = "Test LetCode Button Page")
    public void testLetCodeButton()  {
        webElement = letCodeButtonPage.GotoButton(driver1);
        letCodeActions.actionClick(webElement);
        softAssert.assertEquals(driver1.getTitle(), "LetCode with Koushik", "The title should be 'Home - LetCode with Koushik'");
        driver1.navigate().back();
    }

    @Test(priority = 4, description = "Test LetCode Location Button")
    public void testLocationButton() {
        webElement = letCodeButtonPage.FindLocation(driver1);
        Point location = letCodeActions.getLocation(webElement);
        softAssert.assertEquals(location.getX(), 304, "The x coordinate should be 0");
        softAssert.assertEquals(location.getY(), 336, "The y coordinate should be 0");
    }

    @Test(priority = 5, description = "Test LetCode Button Color")
    public void testColor() {
        webElement = letCodeButtonPage.FindColor(driver1);
        String color = letCodeActions.getColor(webElement, "background-color");
        softAssert.assertEquals(color, "rgba(42, 157, 144, 1)", "The color should be 'rgb(255, 255, 255)'");
    }

    @Test(priority = 6, description = "Test LetCode Button Height and Width")
    public void testHeightWidthButton() {
        webElement = letCodeButtonPage.HeightWidthButton(driver1);
        Rectangle rectangle = letCodeActions.getRectangle(webElement);
        softAssert.assertEquals(rectangle.getHeight(), 40, "The height should be 50");
        softAssert.assertEquals(rectangle.getWidth(), 174, "The width should be 100");
    }

    @Test(priority = 7, description = "Test LetCode Button Disabled")
    public void testDisabledButton() {
        webElement = letCodeButtonPage.ISDisabled(driver1);
        boolean enabled = letCodeActions.isEnabled(webElement);
        softAssert.assertFalse(enabled, "The button should not be enabled");
    }

    @Test(priority = 8, description = "Test LetCode Hold Button ")
    public void testHoldButton(){
        webElement = letCodeButtonPage.ButtonHold(driver1);
        String title = letCodeActions.actionHoldData(webElement, driver1);
        System.out.println(title);
        softAssert.assertEquals(title, "Button has been long pressed", "The title should be 'Button has been long pressed'");
    }
}

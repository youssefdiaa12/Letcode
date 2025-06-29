package LetCodePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LetCodeRadioPage {


    public WebElement getRadio(WebDriver driver, String value) {

        return driver.findElement(By.id(value));
    }

    public boolean isRadioSelected(WebDriver driver, String value) {
        WebElement radio = getRadio(driver, value);
        return radio.isSelected();
    }

    public boolean isRadioEnabled(WebDriver driver, String value) {
        WebElement radio = getRadio(driver, value);
        radio.getAttribute("disabled");
        return radio.isEnabled();
    }

    public void clickCheckBox(WebDriver driver, String value) {
        WebElement checkbox = driver.findElement(By.cssSelector(value + " > input[type='checkbox']"));
        checkbox.click();

    }
    public boolean isCheckBoxSelected(WebDriver driver, String value) {
        WebElement checkbox = driver.findElement(By.cssSelector( value + " > input[type='checkbox']"));
        return checkbox.isSelected();
    }
}
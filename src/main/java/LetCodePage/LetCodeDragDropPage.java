package LetCodePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LetCodeDragDropPage {

    protected By draggable = By.id("sample-box");

    public WebElement getDraggable(WebDriver driver) {
        return driver.findElement(draggable);
    }

}
package LetCodePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetCodeFilePage {


    private By fileInputUpload = By.className("file-label");
    private By fileDownloadButton = By.id("xls");
    private By fileDownloadButtonByLinkText = By.linkText("Download Excel");
    private By XLS = By.id("xls");
    public WebElement fileInputUpload(WebDriver driver) {
        return driver.findElement(fileInputUpload);
    }
    public WebElement XLS(WebDriver driver) {
        return driver.findElement(XLS);
    }
    public WebElement fileDownloadButton(WebDriver driver) {
        return driver.findElement(fileDownloadButton);
    }

    public WebElement fileDownloadButtonByLinkText(WebDriverWait wait) {
       return wait.until(ExpectedConditions.elementToBeClickable(fileDownloadButtonByLinkText));
    }

    public void UpdateFileName(String name) {
        fileDownloadButton = By.id(name);
    }
}
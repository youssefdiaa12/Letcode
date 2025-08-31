package LetCodePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LetCodeFilePage {


    private By fileInputUpload = By.className("file-label");
    private By fileDownloadButton = By.id("xls");
    private By fileDownloadButtonByLinkText = By.linkText("Download Excel");

    public WebElement fileInputUpload(WebDriver driver) {
        return driver.findElement(fileInputUpload);
    }

    public WebElement fileDownloadButton(WebDriver driver) {
        return driver.findElement(fileDownloadButton);
    }

    public WebElement fileDownloadButtonByLinkText(WebDriver driver) {
        return driver.findElement(fileDownloadButtonByLinkText);
    }

    public void UpdateFileName(String name) {
        fileDownloadButton = By.id(name);
    }
}
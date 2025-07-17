package LetCodePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    private By firstNameField = By.name("first_name");
    private By lastNameField = By.name("last_name");
    private By submitButton = By.id("submit");
    private By confirmationMessage = By.id("confirmation");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}


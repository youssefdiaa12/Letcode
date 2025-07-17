package LetCode;

import LetCodePage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;


public class LoginTest extends Driver {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        super.setUp();
        loginPage = new LoginPage(driver1);

    }

    @Test(dataProvider = "formData")
    public void testFormSubmission(String firstName, String lastName) {
        loginPage.enterFirstName(firstName);
        loginPage.enterLastName(lastName);
        loginPage.submitForm();

        String confirmation = loginPage.getConfirmationMessage();
        Assert.assertTrue(confirmation.contains("Thank you"));
    }

    @DataProvider(name = "formData")
    public Object[][] formDataProvider() throws IOException {
        return readCSVData("/src/test.csv");
    }

    @AfterMethod
    public void tearDown() {
        driver1.quit();
    }
}



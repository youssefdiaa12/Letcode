package LetCode;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Driver {
    protected static WebDriver driver1;

    protected static SoftAssert softAssert;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        // Initialize only once
        if (driver1 == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver1 = new ChromeDriver(options);
            driver1.get("https://letcode.in/edit");
            driver1.manage().window().maximize();
            driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }
        softAssert = new SoftAssert();
    }


    public void navigateTo(String url) {
        if (driver1 != null) {
            driver1.navigate().to(url);
        } else {
            System.out.println("Driver is not initialized.");
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver1 != null) {
            driver1.quit();
        }
        softAssert = null;
        driver1 = null;
    }

//@BeforeMethod
//    public void beforeMethod() {
//        // This method can be used to reset the state before each test method if needed
//        if (driver1 != null) {
//            driver1.navigate().refresh();
//        }
//    }
//    @AfterMethod(alwaysRun = true)
//    public void afterMethod() {
//        // This method can be used to perform actions after each test method if needed
//        // For example, you can log the results or take screenshots
//        System.out.println("Test method completed.");
//    }
}



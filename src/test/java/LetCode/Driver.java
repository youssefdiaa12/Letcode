package LetCode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Driver {
    protected static WebDriver driver1;

    @BeforeClass(alwaysRun = true)
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
    }


    @AfterClass
    public void tearDown() {
        if (driver1 != null) {
            driver1.quit();
        }
    }

@BeforeMethod
    public void beforeMethod() {
        // This method can be used to reset the state before each test method if needed
        if (driver1 != null) {
            driver1.navigate().refresh();
        }
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        // This method can be used to perform actions after each test method if needed
        // For example, you can log the results or take screenshots
        System.out.println("Test method completed.");
    }
}



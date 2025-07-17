package LetCode;
import LetCodeActions.LetCodeActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    protected static WebDriver driver1;
    protected static LetCodeActions letCodeActions;
    protected static SoftAssert softAssert;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws InterruptedException {
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
        letCodeActions = new LetCodeActions();
    }


    public void navigateTo(String url) {
        if (driver1 != null) {
            driver1.navigate().to(url);
        } else {
            System.out.println("Driver is not initialized.");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver1 != null) {
            driver1.quit();
        }
        softAssert = null;
        driver1 = null;
    }

    public static Object[][] readCSVData(String filePath) throws IOException {
        List<Object[]> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        boolean isFirstLine = true;

        while ((line = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false; // Skip header
                continue;
            }
            String[] fields = line.split(",");
            data.add(fields);
        }

        reader.close();
        return data.toArray(new Object[0][]);
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



//package LetCode;
////import Utilis.ExtentTestManager;
//import Utilis.ScreenShots;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.apache.commons.io.FileUtils;
//import java.io.File;
//import java.io.IOException;
//
//public class TestListener implements ITestListener {
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        ExtentTestManager.startTest(result.getMethod().getMethodName(), "Test Started");
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        ExtentTestManager.getTest().pass("Test Passed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//
//        File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
//        String screenshotPath = ScreenShots.captureScreenshot(Driver.getDriver(), result.getName());
//        try {
//            FileUtils.copyFile(src, new File(screenshotPath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ExtentTestManager.getTest().fail("Test Failed: " + result.getThrowable(),
//                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        ExtentTestManager.getTest().skip("Test Skipped: " + result.getThrowable());
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        ExtentTestManager.endTest();
//    }
//}

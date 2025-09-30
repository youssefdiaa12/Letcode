//package Utilis;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ExtentManager {
//    private static ExtentReports extent;
//
//    public static ExtentReports getInstance() {
//        if (extent == null) {
//            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extent-report.html");
//            reporter.config().setReportName("Automation Test Report");
//            reporter.config().setDocumentTitle("Test Execution Report");
//            extent = new ExtentReports();
//            extent.attachReporter(reporter);
//            extent.setSystemInfo("Tester", "Youssef Soltan");
//        }
//        return extent;
//    }
//}
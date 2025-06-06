package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import basepackage.BaseClass;

public class Extentreport implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    public String repName;

    @Override
    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timestamp + ".html";
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + repName);

        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "OpenCart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        String os = context.getCurrentXmlTest().getParameter("os");
        String browser = context.getCurrentXmlTest().getParameter("browser");
        if (os != null) extent.setSystemInfo("Operating System", os);
        if (browser != null) extent.setSystemInfo("Browser", browser);

        List<String> includeGroups = context.getCurrentXmlTest().getIncludedGroups();
        if (!includeGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includeGroups.toString());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable());

        try {
            String imgPath = new BaseClass().captureScreenshot(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

        try {
            File reportFile = new File(System.getProperty("user.dir") + "/reports/" + repName);
            if (reportFile.exists()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

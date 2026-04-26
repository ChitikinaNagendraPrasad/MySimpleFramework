package com.test.Listener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.Base.DriverManager;

public class MyTestListener implements ITestListener, ISuiteListener
{
    /* ================= THREAD SAFE TEST LOG ================= */
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    /* ================= INDIVIDUAL REPORTS ================= */
    private static Map<String, ExtentReports> extentReportMap = new ConcurrentHashMap<>();
    /* ================= PER TEST START TIMES ================= */
    private static Map<String, Long> testStartTimes = new ConcurrentHashMap<>();
    /* ================= MASTER REPORT ================= */ 
    private static ExtentReports masterExtent;
    private static ExtentTest masterDashboard;
    /* ================= SUITE METRICS ================= */ 
    private static long suiteStartTime;
    private static long cumulativeDurationMillis;
    private static int suiteTotal;
    private static int suitePassed;
    private static int suiteFailed;
    private static int suiteSkipped;
    /* ================= EXECUTION PROGRESS (ADDED) ================= */ 
    private static int totalTestMethods;
    private static final AtomicInteger currentTestIndex = new AtomicInteger(0);
    /*
     * ===================================================== SUITE START
     * =====================================================
     */ @Override
    public void onStart(ISuite suite)
    {
        suiteStartTime = System.currentTimeMillis();
        cumulativeDurationMillis = 0;
        cleanDirectory("Reports");
        cleanDirectory("Screenshots");
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String masterPath = System.getProperty("user.dir") + "/Reports/Master_Summary_" + timestamp + ".html";
        ExtentSparkReporter masterSpark = new ExtentSparkReporter(masterPath);
        masterSpark.config().setReportName("Automation Execution Summary");
        masterSpark.config().setDocumentTitle("Master Summary");
        masterExtent = new ExtentReports();
        masterExtent.attachReporter(masterSpark);
        masterDashboard = masterExtent.createTest("🏁 Execution Dashboard");
    }

    /*
     * ===================================================== TEST START (<test>)
     * =====================================================
     */ @Override
    public synchronized void onStart(ITestContext context)
    {
        String testName = context.getName();
        String browser = context.getCurrentXmlTest().getParameter("browser");
        testStartTimes.put(testName, System.currentTimeMillis());
        /* ---------- PROGRESS SETUP (ADDED) ---------- */ totalTestMethods = context.getAllTestMethods().length;
        currentTestIndex.set(0);
        System.out.println("\n===== TEST EXECUTION STARTED =====");
        System.out.println("Total Test Methods: " + totalTestMethods);
        /* -------------------------------------------- */ String reportPath = System.getProperty("user.dir") + "/Reports/" + testName + "_"
                + browser + ".html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName("Automation Execution Report");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Test Name", testName);
        extent.setSystemInfo("Browser", browser);
        extent.setSystemInfo("Thread", Thread.currentThread().getName() + " | ID: " + Thread.currentThread().getId());
        extentReportMap.put(testName, extent);
    }

    /*
     * ===================================================== TEST METHOD START
     * =====================================================
     */ @Override
    public synchronized void onTestStart(ITestResult result)
    {
        /* ---------- PROGRESS OUTPUT (ADDED) ---------- */ 
         int running = currentTestIndex.incrementAndGet();
        //System.out.println("▶ Running test " + running + " / " + totalTestMethods + " : " + result.getMethod().getMethodName());
         System.out.println("▶ Running test " + running + " : " + result.getMethod().getMethodName());
        /* --------------------------------------------- */ String testName = result.getTestContext().getName();
        ExtentTest test = extentReportMap.get(testName).createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        test.info("Thread → " + Thread.currentThread().getName());
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        extentTest.get().pass("✅ PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        ExtentTest test = extentTest.get();
        test.fail(result.getThrowable());
        WebDriver driver = DriverManager.getDriver();
        if (driver != null)
        {
            try
            {
                ScreenshotData sc = captureScreenshot(result.getMethod().getMethodName(), driver);
                test.addScreenCaptureFromBase64String(sc.base64, sc.fileName);
            }
            catch (Exception e)
            {
                test.warning("Screenshot failed");
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        ExtentTest test = extentTest.get();
        test.skip("⚠ SKIPPED");
        if (result.getThrowable() != null)
        {
            test.skip(result.getThrowable());
        }
    }

    /*
     * ===================================================== TEST FINISH
     * =====================================================
     */ @Override
    public synchronized void onFinish(ITestContext context)
    {
        long endTime = System.currentTimeMillis();
        long startTime = testStartTimes.get(context.getName());
        long testDuration = endTime - startTime;
        cumulativeDurationMillis += testDuration;
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        suitePassed += passed;
        suiteFailed += failed;
        suiteSkipped += skipped;
        ExtentReports extent = extentReportMap.get(context.getName());
        if (extent != null)
        {
            int tcTotal = passed + failed + skipped;
            extent.setSystemInfo("Total Tests", String.valueOf(tcTotal));
            extent.setSystemInfo("Passed", String.valueOf(passed));
            extent.setSystemInfo("Failed", String.valueOf(failed));
            extent.setSystemInfo("Skipped", String.valueOf(skipped));
            extent.setSystemInfo("Execution Time", formatDuration(testDuration));
            extent.flush();
            extentReportMap.remove(context.getName());
        }
        extentTest.remove();
    }

    /*
     * ===================================================== SUITE FINISH
     * =====================================================
     */ @Override
    public void onFinish(ISuite suite)
    {
        long elapsedMillis = System.currentTimeMillis() - suiteStartTime;
        String elapsedTime = formatDuration(elapsedMillis);
        suiteTotal = suitePassed + suiteFailed + suiteSkipped;
        masterDashboard.info("🧪 Total Tests        : " + suiteTotal)
                       .pass("✅ Passed             : " + suitePassed)
                       .fail("❌ Failed             : " + suiteFailed)
                       .warning("⚠ Skipped            : " + suiteSkipped)
                       .info("⏱ Total Elapsed Time : " + elapsedTime);
        masterExtent.setSystemInfo("Total Tests", String.valueOf(suiteTotal));
        masterExtent.setSystemInfo("Passed", String.valueOf(suitePassed));
        masterExtent.setSystemInfo("Failed", String.valueOf(suiteFailed));
        masterExtent.setSystemInfo("Skipped", String.valueOf(suiteSkipped));
        masterExtent.setSystemInfo("Total Elapsed Time", elapsedTime);
        masterExtent.flush();
    }

    /*
     * ===================================================== UTILITIES
     * =====================================================
     */ private String formatDuration(long millis)
    {
        long seconds = millis / 1000;
        long hours = seconds / 3600;
        long mins = (seconds % 3600) / 60;
        long secs = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, mins, secs);
    }

    private ScreenshotData captureScreenshot(String methodName, WebDriver driver) throws IOException
    {
        File dir = new File(System.getProperty("user.dir") + "/Screenshots");
        if (!dir.exists())
            dir.mkdirs();
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(dir, methodName + ".png");
        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return new ScreenshotData(dest.getName(), base64);
    }

    private void cleanDirectory(String folder)
    {
        File dir = new File(System.getProperty("user.dir") + "/" + folder);
        if (!dir.exists())
            return;
        for (File f : dir.listFiles())
        {
            f.delete();
        }
    }

    private static class ScreenshotData
    {
        String fileName;
        String base64;

        ScreenshotData(String f, String b)
        {
            fileName = f;
            base64 = b;
        }
    }

    public static ExtentTest getExtentTest()
    {
        return extentTest.get();
    }
}
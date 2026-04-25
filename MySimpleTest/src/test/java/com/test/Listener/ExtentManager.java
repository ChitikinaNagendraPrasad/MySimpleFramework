package com.test.Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager
{
    public static ExtentReports createInstance(String filePath)
    {
        ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
        spark.config().setReportName("Automation Execution Report");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        return extent;
    }
}
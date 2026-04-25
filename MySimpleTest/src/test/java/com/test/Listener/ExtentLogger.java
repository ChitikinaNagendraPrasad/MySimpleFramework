package com.test.Listener;

import com.aventstack.extentreports.ExtentTest;

public class ExtentLogger {

    private ExtentLogger() {
        // prevent object creation
    }

    private static ExtentTest getTest() {
        return MyTestListener.getExtentTest();
    }

    public static void info(String message) {
        getTest().info(message);
    }

    public static void pass(String message) {
        getTest().pass(message);
    }

    public static void fail(String message) {
        getTest().fail(message);
    }

    public static void warning(String message) {
        getTest().warning(message);
    }
}
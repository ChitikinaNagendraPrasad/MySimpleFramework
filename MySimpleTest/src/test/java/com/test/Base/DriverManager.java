
package com.test.Base;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {
        // prevent instantiation
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    // ✅ Safe quit (no TimeoutException)
    public static void quitDriver() {
        WebDriver webDriver = driver.get();
        try {
            if (webDriver != null) {
                webDriver.quit();
            }
        } catch (Exception e) {
            System.out.println("Driver already closed. Ignoring quit exception.");
        } finally {
            driver.remove(); // VERY IMPORTANT
        }
    }
}

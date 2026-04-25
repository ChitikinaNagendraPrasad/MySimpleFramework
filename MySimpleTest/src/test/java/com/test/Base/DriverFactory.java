
package com.test.Base;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

    private DriverFactory() {
        // prevent instantiation
    }

    public static WebDriver createDriver(
            String browser,
            String runMode,
            String gridURL,
            String headless) {

        try {
            if ("grid".equalsIgnoreCase(runMode)) {
                return createRemoteDriver(browser, gridURL, headless);
            } else {
                return createLocalDriver(browser, headless);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create WebDriver", e);
        }
    }

    // ================= LOCAL =================

    private static WebDriver createLocalDriver(String browser, String headless) {

        switch (browser.toLowerCase()) {

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(getFirefoxOptions(headless));

            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver(getEdgeOptions(headless));

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(getChromeOptions(headless));
        }
    }

    // ================= GRID =================

    private static WebDriver createRemoteDriver(
            String browser, String gridURL, String headless) throws Exception {

        URL grid = new URL(gridURL);

        switch (browser.toLowerCase()) {

            case "firefox":
                return new RemoteWebDriver(grid, getFirefoxOptions(headless));

            case "edge":
                return new RemoteWebDriver(grid, getEdgeOptions(headless));

            case "chrome":
            default:
                return new RemoteWebDriver(grid, getChromeOptions(headless));
        }
    }

    // ================= OPTIONS =================

    private static ChromeOptions getChromeOptions(String headless) {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        } else {
            options.addArguments("--start-maximized");
        }

        return options;
    }

    private static FirefoxOptions getFirefoxOptions(String headless) {
        FirefoxOptions options = new FirefoxOptions();
        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("-headless");
        }
        return options;
    }

    private static EdgeOptions getEdgeOptions(String headless) {
        EdgeOptions options = new EdgeOptions();

        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        } else {
            options.addArguments("--start-maximized");
        }

        return options;
    }
}

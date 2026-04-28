
package com.test.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest
{
    @Parameters({ "browser", "runMode", "gridURL", "baseURL", "headless" }) 
    @BeforeMethod(alwaysRun = true)
    public void setUp(
            @Optional("chrome") String browser, 
            @Optional("local") String runMode,
            @Optional("http://localhost:4444/wd/hub") String gridURL, 
            @Optional("https://automationexercise.com") String baseURL,
            @Optional("false") String headless)
    {
        WebDriver driver = DriverFactory.createDriver(browser, runMode, gridURL, headless);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        DriverManager.getDriver().get(baseURL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        DriverManager.quitDriver(); // ✅ only one quit
    }
}
package com.test.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.Base.DriverManager;
import com.test.Listener.ExtentLogger;

public class GenericMethods
{

    public static void waitForElement(WebDriver driver, By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));   
    }

    public static void clickOn(WebDriver driver, By by)
    {
        waitForElement(DriverManager.getDriver(), by);
        //driver.findElement(by).click();        
        DriverManager.getDriver().findElement(by).click();
    }

    public static void enterDataInTextBox(WebDriver driver, By by, String data)
    {
        waitForElement(DriverManager.getDriver(), by);
        //driver.findElement(by).sendKeys(data);
        DriverManager.getDriver().findElement(by).sendKeys(data);
    }
    
    public static void selectDropDownItem_BasedOnValue(WebDriver driver, By by, String optionValueToSelect)
    {
        waitForElement(DriverManager.getDriver(), by);
        //Select dropDown = new Select(driver.findElement(by));
        Select dropDown = new Select(DriverManager.getDriver().findElement(by));
        dropDown.selectByContainsVisibleText(optionValueToSelect);
    }

    public static void verifyErrorMessage(WebDriver driver, String actualErrorMessage, String expectedErrorMessage, String testCaseName)
    {
        if (actualErrorMessage.equalsIgnoreCase(expectedErrorMessage))
        {
            printSuccessMessageInReport(actualErrorMessage,expectedErrorMessage);
            Assert.assertTrue(true);            
        }
        else
        {            
            printFailureMessageInReport(actualErrorMessage,expectedErrorMessage);
            Assert.assertTrue(false);
        }
    }

    public static String getTextFromElement(WebDriver driver, By by)
    {
        waitForElement(DriverManager.getDriver(), by);
        //return driver.findElement(by).getText();
        return  DriverManager.getDriver().findElement(by).getText();
    }

    public static void takeScreenShot(WebDriver driver, String screenshotName) throws FileNotFoundException
    {

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy_HH.mm.ss"));
        String screenShotsFolderPath = System.getProperty("user.dir") + "\\ScreenShots\\";

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(screenShotsFolderPath + screenshotName+"_"+timestamp+".png");
        //File dest = new File(screenShotsFolderPath + screenshotName+".png");
        try
        {
            FileUtils.moveFile(src, dest);
            System.out.println("Filed Moved .. Successfully");
            System.out.println("Hai");
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void printSuccessMessageInReport(String actualErrorMessage, String expectedErrorMessage)
    {
        ExtentLogger.info("Actual Error Message   : "+actualErrorMessage+"<BR>Expected Error Message :"+expectedErrorMessage+"<BR>Error Message Validation : Success \u2705");
    }

    public static void printFailureMessageInReport(String actualErrorMessage, String expectedErrorMessage)
    {
        ExtentLogger.info("Actual Error Message   : "+actualErrorMessage+"<BR>Expected Error Message :"+expectedErrorMessage+"<BR>Error Message Validation : Failure \u274C");
    }
}

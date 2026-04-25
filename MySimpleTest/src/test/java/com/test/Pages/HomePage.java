/*
 * package com.test.Pages;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver;
 * 
 * import com.test.Listener.ExtentLogger; import
 * com.test.Utilities.GenericMethods;
 * 
 * public class Home_Page { WebDriver driver;
 * 
 * public Home_Page(WebDriver driver) { this.driver = driver; }
 * 
 * By HomePage_Home_Link = By.xpath("//a[normalize-space()='Home']"); By
 * HomePage_Products_Link = By.xpath("//a[@href='/products']"); By
 * HomePage_Cart_Link = By.xpath("//a[contains(text(),'Cart')]"); By
 * HomePage_SignUp_Or_Login_Link =
 * By.xpath("//a[normalize-space()='Signup / Login']");
 * 
 * public void click_HomePage_SignUp_Or_Login_Link() {
 * GenericMethods.clickOn(driver, HomePage_SignUp_Or_Login_Link);
 * ExtentLogger.info("User Clicked On Login Button On"); } }
 */

package com.test.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.Base.DriverManager;
import com.test.Listener.ExtentLogger;

public class HomePage
{

    // ✅ Locators
    private final By homeLink = By.xpath("//a[normalize-space()='Home']");
    private final By productsLink = By.xpath("//a[@href='/products']");
    private final By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    private final By signupLoginLink = By.xpath("//a[normalize-space()='Signup / Login']");

    // ✅ Centralized wait (Grid & Docker friendly)
    private WebDriverWait getWait()
    {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }
    
    // ✅ Click Signup / Login
    public HomePage clickSignupLogin()
    {
        //WebDriver driver = DriverManager.getDriver();
        getWait().until(ExpectedConditions.elementToBeClickable(signupLoginLink)).click();
        ExtentLogger.info("Clicked on 'Signup / Login' link on Home page");
        return this; // enables fluent chaining
    }

    // ✅ Example additional action
    public HomePage clickProducts()
    {
        getWait().until(ExpectedConditions.elementToBeClickable(productsLink)).click();
        ExtentLogger.info("Clicked on 'Products' link");
        return this;
    }
}
/*
 * package com.test.Pages;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver;
 * 
 * import com.test.Listener.ExtentLogger; import
 * com.test.Utilities.GenericMethods;
 * 
 * public class SignUpOrLogin_Page { WebDriver driver; public
 * SignUpOrLogin_Page(WebDriver driver) { this.driver=driver; }
 * 
 * //1. Login To Your Account Section By loginSection_EmailAddress_TextBox =
 * By.xpath("//input[@data-qa='login-email']"); By loginSection_Password_TextBox
 * = By.xpath("//input[@placeholder='Password']"); By loginSection_Login_Button
 * = By.xpath("//button[normalize-space()='Login']"); //Error Messages By
 * loginSection_Email_InCorrect_Error =
 * By.xpath("//p[normalize-space()='Your email or password is incorrect!']");
 * 
 * 
 * public void enterDataIn_loginSection_EmailAddress_TextBox(String data) {
 * GenericMethods.enterDataInTextBox(driver, loginSection_EmailAddress_TextBox,
 * data); }
 * 
 * public void enterDataIn_loginSection_Password_TextBox(String data) {
 * GenericMethods.enterDataInTextBox(driver, loginSection_Password_TextBox,
 * data); }
 * 
 * public void click_loginSection_Login_Button() {
 * GenericMethods.clickOn(driver, loginSection_Login_Button); }
 * 
 * public void verify_Email_Or_Password_Incorrect_ErrorMessage(String
 * testCaseName) { String
 * expectedErrorMessage="Your email or password is incorrect!"; String
 * actualErrorMessage = GenericMethods.getTextFromElement(driver,
 * loginSection_Email_InCorrect_Error);
 * GenericMethods.verifyErrorMessage(driver, actualErrorMessage,
 * expectedErrorMessage,testCaseName); }
 * 
 * public void verify_EmailAlreadyExists_ErrorMessage(String testCaseName) {
 * String expectedErrorMessage="Email Address already exist!"; String
 * actualErrorMessage = GenericMethods.getTextFromElement(driver,
 * signUpSection_EmailAddress_Already_Exist_Error);
 * GenericMethods.verifyErrorMessage(driver, actualErrorMessage,
 * expectedErrorMessage,testCaseName);
 * ExtentLogger.info("Successfully Verified The Error Message : "
 * +expectedErrorMessage); }
 * 
 * public void loginToYourAccount(String emailAddress, String password) {
 * enterDataIn_loginSection_EmailAddress_TextBox(emailAddress);
 * enterDataIn_loginSection_Password_TextBox(password);
 * click_loginSection_Login_Button();
 * ExtentLogger.info("Successfully Entered Email Address ("+emailAddress+")");
 * ExtentLogger.info("Successfully Entered Password ("+password+")");
 * ExtentLogger.info("Successfully Clicked Login Button"); }
 * 
 * //--------------------------------------------
 * 
 * //2. New User SignUp Section By signUpSection_Name_TextBox =
 * By.xpath("//input[@placeholder='Name']"); By signUpSection_Email_TextBox =
 * By.xpath("//input[@data-qa='signup-email']"); By signUpSection_SignUp_Button
 * = By.xpath("//button[normalize-space()='Signup']");
 * 
 * //Error Messages
 * 
 * By signUpSection_EmailAddress_Already_Exist_Error =
 * By.xpath("//p[normalize-space()='Email Address already exist!']");
 * 
 * public void enterDataIn_signUpSection_Name_TextBox(String data) {
 * GenericMethods.enterDataInTextBox(driver, signUpSection_Name_TextBox, data);
 * }
 * 
 * public void enterDataIn_signUpSection_Email_TextBox(String data) {
 * GenericMethods.enterDataInTextBox(driver, signUpSection_Email_TextBox, data);
 * }
 * 
 * public void click_signUpSection_SignUp_Button() {
 * GenericMethods.clickOn(driver, signUpSection_SignUp_Button); }
 * 
 * public void initiateSignUp(String name, String emailAddress) {
 * enterDataIn_signUpSection_Name_TextBox(name);
 * enterDataIn_signUpSection_Email_TextBox(emailAddress);
 * click_signUpSection_SignUp_Button();
 * ExtentLogger.info("Successfully Entered Name ("+name+")");
 * ExtentLogger.info("Successfully Entered Email ("+emailAddress+")");
 * ExtentLogger.info("Successfully Clicked SignUp Button"); } }
 */

package com.test.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.Base.DriverManager;
import com.test.Listener.ExtentLogger;

public class SignUpOrLoginPage
{
    // ================= LOGIN SECTION =================
    private final By loginEmailTextBox = By.xpath("//input[@data-qa='login-email']");
    private final By loginPasswordTextBox = By.xpath("//input[@placeholder='Password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");
    private final By loginErrorMessage = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

    // ================= SIGNUP SECTION =================
    private final By signupNameTextBox = By.xpath("//input[@placeholder='Name']");
    private final By signupEmailTextBox = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton = By.xpath("//button[normalize-space()='Signup']");
    private final By emailAlreadyExistsError = By.xpath("//p[normalize-space()='Email Address already exist!']");

    // ================= WAIT =================
    private WebDriverWait getwait()
    {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    // ================= LOGIN ACTIONS =================

    public SignUpOrLoginPage enterLoginEmail(String email)
    {
        getwait().until(ExpectedConditions.visibilityOfElementLocated(loginEmailTextBox)).sendKeys(email);
        ExtentLogger.info("Entered login email: " + email);
        return this;
    }

    public SignUpOrLoginPage enterLoginPassword(String password)
    {
        getwait().until(ExpectedConditions.visibilityOfElementLocated(loginPasswordTextBox)).sendKeys(password);
        ExtentLogger.info("Entered login password");
        return this;
    }

    public SignUpOrLoginPage clickLoginButton()
    {
        getwait().until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        ExtentLogger.info("Clicked Login button");
        return this;
    }

    public String getLoginErrorMessage()
    {
        String errorText = getwait().until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage)).getText();
        ExtentLogger.info("Login error message displayed: " + errorText);
        return errorText;
    }

    public void login(String email, String password)
    {
        enterLoginEmail(email).enterLoginPassword(password).clickLoginButton();
    }

    // ================= SIGNUP ACTIONS =================

    public SignUpOrLoginPage enterSignupName(String name)
    {
        getwait().until(ExpectedConditions.visibilityOfElementLocated(signupNameTextBox)).sendKeys(name);
        ExtentLogger.info("Entered signup name: " + name);
        return this;
    }

    public SignUpOrLoginPage enterSignupEmail(String email)
    {
        getwait().until(ExpectedConditions.visibilityOfElementLocated(signupEmailTextBox)).sendKeys(email);
        ExtentLogger.info("Entered signup email: " + email);
        return this;
    }

    public SignUpOrLoginPage clickSignupButton()
    {
        getwait().until(ExpectedConditions.elementToBeClickable(signupButton)).click();
        ExtentLogger.info("Clicked Signup button");
        return this;
    }

    public String getEmailAlreadyExistsErrorMessage()
    {
        String errorText = getwait().until(ExpectedConditions.visibilityOfElementLocated(emailAlreadyExistsError)).getText();
        ExtentLogger.info("Signup error message displayed: " + errorText);
        return errorText;
    }

    public void signup(String name, String email)
    {
        enterSignupName(name).enterSignupEmail(email).clickSignupButton();
    }
}
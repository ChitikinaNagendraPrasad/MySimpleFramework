/*
 * package com.test.TestCases;
 * 
 * import org.testng.Reporter; import org.testng.annotations.Test;
 * 
 * import com.test.Base.BaseTest; import com.test.Base.DriverManager; import
 * com.test.Pages.HomePage; import com.test.Pages.SignUpOrLoginPage; import
 * com.test.Pages.SignUpPage;
 * 
 * public class TestCases_1 extends BaseTest { HomePage homePage = null;
 * SignUpOrLoginPage signUpOrLoginPage = null; SignUpPage signUpPage = null;
 * 
 * public void initializeAllPages() { homePage = new HomePage();
 * signUpOrLoginPage = new SignUpOrLoginPage(); signUpPage = new SignUpPage(); }
 * 
 * @Test(enabled = true) public void testCase_001() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_002() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_003() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_004() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_005() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_006() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_007() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_008() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_009() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_010() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_011() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_012() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_013() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_014() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_015() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_016() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_017() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_018() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_019() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_020() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_021() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_022() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_023() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.loginToYourAccount("nag@nag.com", "11111111");
 * signUpOrLoginPage.verify_Email_Or_Password_Incorrect_ErrorMessage(testName);
 * }
 * 
 * @Test(enabled = true) public void testCase_024() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); }
 * 
 * @Test(enabled = true) public void testCase_025() throws Throwable {
 * initializeAllPages(); String testName =
 * Reporter.getCurrentTestResult().getMethod().getMethodName();
 * homePage.click_HomePage_SignUp_Or_Login_Link();
 * signUpOrLoginPage.initiateSignUp("Nagendra", "nage@nag.com"); //
 * signUp_Page.enterDetailsIn_SignUp_Page();
 * signUpOrLoginPage.verify_EmailAlreadyExists_ErrorMessage(testName); } }
 */

package com.test.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.Base.BaseTest;
import com.test.Pages.HomePage;
import com.test.Pages.SignUpOrLoginPage;

public class TestCases_2 extends BaseTest
{

    private HomePage homePage;
    private SignUpOrLoginPage signUpOrLoginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpPages()
    {
        homePage = new HomePage();
        signUpOrLoginPage = new SignUpOrLoginPage();
    }

    // ===================== LOGIN TEST =====================

    @Test(dataProvider = "invalidLoginData")
    public void verifyLoginWithInvalidCredentials(String email, String password)
    {

        homePage.clickSignupLogin();

        signUpOrLoginPage.login(email, password);

        String actualError = signUpOrLoginPage.getLoginErrorMessage();

        Assert.assertEquals(actualError, "Your email or password is incorrect!", "Login error message mismatch");
    }

    // ===================== SIGNUP TEST =====================

    @Test(dataProvider = "existingSignupData")
    public void verifySignupWithExistingEmail(String name, String email)
    {
        homePage.clickSignupLogin();
        signUpOrLoginPage.signup(name, email);
        String actualError = signUpOrLoginPage.getEmailAlreadyExistsErrorMessage();
        Assert.assertEquals(actualError, "Email Address already exist!", "Signup error message mismatch");
    }

    // ===================== DATA PROVIDERS =====================

    @DataProvider(name = "invalidLoginData", parallel = true)
    public Object[][] invalidLoginData()
    {
        return new Object[][]
        {
                { "nag@nag.com", "wrongpass" },
                { "test@test.com", "123456" },
                { "user@demo.com", "password" } };
    }

    @DataProvider(name = "existingSignupData", parallel = true)
    public Object[][] existingSignupData()
    {
        return new Object[][]
        {
                { "Nagendra", "nage@nag.com" },
                { "TestUser", "existing@test.com" },
                { "DemoUser", "user@demo.com" } };
    }
}
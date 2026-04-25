package com.test.TestCases;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.test.Base.BaseTest;
import com.test.Pages.HomePage;
import com.test.Pages.SignUpOrLoginPage;

public class TestCases_1 extends BaseTest
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
                { "user@demo.com", "password" } 
        };
    }

    @DataProvider(name = "existingSignupData", parallel = true)
    public Object[][] existingSignupData()
    {
        return new Object[][]
        {
                { "Nagendra", "nage@nag.com" },
                { "TestUser", "existing@test.com" },
                { "DemoUser", "user@demo.com" } 
        };
    }
}
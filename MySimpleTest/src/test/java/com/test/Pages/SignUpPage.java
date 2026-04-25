/*
 * package com.test.Pages;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver;
 * 
 * import com.test.Utilities.GenericMethods;
 * 
 * public class SignUp_Page { WebDriver driver;
 * 
 * public SignUp_Page(WebDriver driver) { this.driver = driver; }
 * 
 * By Title_Mr_RadioButton = By.xpath("//input[@id='id_gender1']"); By
 * Title_Mrs_RadioButton = By.xpath("//input[@id='id_gender2']"); By
 * Name_TextBox = By.xpath("//input[@id='name']"); By Email_TextBox =
 * By.xpath("//input[@id='email']"); By Password_TextBox =
 * By.xpath("//input[@id='password']"); By DOB_Days_DropDown=
 * By.xpath("//select[@id='days']"); By DOB_Month_DropDown =
 * By.xpath("//select[@id='months']"); By DOB_Year_DropDown =
 * By.xpath("//select[@id='years']"); By NewsLetter_SignUp_CheckBox =
 * By.xpath("//input[@id='newsletter']"); By Receive_SpecialOffers_CheckBox =
 * By.xpath("//input[@id='optin']"); By FirstName_TextBox =
 * By.xpath("//input[@id='first_name']"); By LastName_TextBox =
 * By.xpath("//input[@id='last_name']"); By
 * Company_TextBox=By.xpath("//input[@id='company']"); By Address_TextBox =
 * By.xpath("//input[@id='address1']"); By Country_DropDown=
 * By.xpath("//select[@id='country']"); By State_TextBox =
 * By.xpath("//input[@id='state']"); By City_TextBox =
 * By.xpath("//input[@id='city']"); By ZipCode_TextBox =
 * By.xpath("//input[@id='zipcode']"); By MobileNumber_TextBox =
 * By.xpath("//input[@id='mobile_number']"); By CreateAccount_Button =
 * By.xpath("//button[normalize-space()='Create Account']");
 * 
 * 
 * public void enterDetailsIn_SignUp_Page() { GenericMethods.clickOn(driver,
 * Title_Mr_RadioButton); GenericMethods.enterDataInTextBox(driver,
 * Password_TextBox, "11111111");
 * GenericMethods.selectDropDownItem_BasedOnValue(driver, DOB_Days_DropDown,
 * "16"); GenericMethods.selectDropDownItem_BasedOnValue(driver,
 * DOB_Month_DropDown, "May");
 * GenericMethods.selectDropDownItem_BasedOnValue(driver, DOB_Year_DropDown,
 * "1977"); GenericMethods.clickOn(driver, NewsLetter_SignUp_CheckBox);
 * GenericMethods.clickOn(driver, Receive_SpecialOffers_CheckBox);
 * GenericMethods.enterDataInTextBox(driver, FirstName_TextBox,
 * "Nagendra Prasad"); GenericMethods.enterDataInTextBox(driver,
 * LastName_TextBox, "Chitikina"); GenericMethods.enterDataInTextBox(driver,
 * Company_TextBox, "Credit Agricole - Corporate Investment Bank");
 * GenericMethods.enterDataInTextBox(driver, Address_TextBox, "Singapore");
 * GenericMethods.selectDropDownItem_BasedOnValue(driver, Country_DropDown,
 * "Singapore"); GenericMethods.enterDataInTextBox(driver, State_TextBox,
 * "Singapore"); GenericMethods.enterDataInTextBox(driver, City_TextBox,
 * "Singapore"); GenericMethods.enterDataInTextBox(driver, ZipCode_TextBox,
 * "533103"); GenericMethods.enterDataInTextBox(driver, MobileNumber_TextBox,
 * "1234567890"); GenericMethods.clickOn(driver, CreateAccount_Button);
 * System.out.println("Hai"); } }
 */

package com.test.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.Base.DriverManager;
import com.test.Listener.ExtentLogger;

public class SignUpPage
{

    // ================== LOCATORS ==================
    private final By titleMrRadio = By.id("id_gender1");
    private final By titleMrsRadio = By.id("id_gender2");
    private final By passwordTextBox = By.id("password");

    private final By daysDropdown = By.id("days");
    private final By monthsDropdown = By.id("months");
    private final By yearsDropdown = By.id("years");

    private final By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");

    private final By firstNameTextBox = By.id("first_name");
    private final By lastNameTextBox = By.id("last_name");
    private final By companyTextBox = By.id("company");
    private final By addressTextBox = By.id("address1");

    private final By countryDropdown = By.id("country");
    private final By stateTextBox = By.id("state");
    private final By cityTextBox = By.id("city");
    private final By zipcodeTextBox = By.id("zipcode");
    private final By mobileTextBox = By.id("mobile_number");

    private final By createAccountButton = By.xpath("//button[normalize-space()='Create Account']");

    // ================== WAIT ==================
    private WebDriverWait getWait()
    {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    // ================== ACTIONS ==================

    public SignUpPage selectTitleMr()
    {
        getWait().until(ExpectedConditions.elementToBeClickable(titleMrRadio)).click();
        ExtentLogger.info("Selected title: Mr");
        return this;
    }

    public SignUpPage enterPassword(String password)
    {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(passwordTextBox)).sendKeys(password);
        ExtentLogger.info("Entered password");
        return this;
    }

    public SignUpPage selectDOB(String day, String month, String year)
    {
        new Select(getWait().until(ExpectedConditions.elementToBeClickable(daysDropdown))).selectByVisibleText(day);

        new Select(getWait().until(ExpectedConditions.elementToBeClickable(monthsDropdown))).selectByVisibleText(month);

        new Select(getWait().until(ExpectedConditions.elementToBeClickable(yearsDropdown))).selectByVisibleText(year);

        ExtentLogger.info("Selected Date of Birth: " + day + "-" + month + "-" + year);
        return this;
    }

    public SignUpPage subscribeToNewsletter()
    {
        getWait().until(ExpectedConditions.elementToBeClickable(newsletterCheckbox)).click();
        ExtentLogger.info("Subscribed to newsletter");
        return this;
    }

    public SignUpPage fillAddressDetails(String firstName, String lastName, String company, String address, String country, String state,
            String city, String zip, String mobile)
    {

        getWait().until(ExpectedConditions.visibilityOfElementLocated(firstNameTextBox)).sendKeys(firstName);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(lastNameTextBox)).sendKeys(lastName);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(companyTextBox)).sendKeys(company);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(addressTextBox)).sendKeys(address);

        new Select(getWait().until(ExpectedConditions.elementToBeClickable(countryDropdown))).selectByVisibleText(country);

        DriverManager.getDriver().findElement(stateTextBox).sendKeys(state);
        DriverManager.getDriver().findElement(cityTextBox).sendKeys(city);
        DriverManager.getDriver().findElement(zipcodeTextBox).sendKeys(zip);
        DriverManager.getDriver().findElement(mobileTextBox).sendKeys(mobile);

        ExtentLogger.info("Entered address and contact details");
        return this;
    }

    public void submitAccountCreation()
    {
        getWait().until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
        ExtentLogger.info("Clicked on Create Account button");
    }
}

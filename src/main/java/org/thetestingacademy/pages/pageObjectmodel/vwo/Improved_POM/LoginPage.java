package org.thetestingacademy.pages.pageObjectmodel.vwo.Improved_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.thetestingacademy.base.CommonToAllPage;
import org.thetestingacademy.utils.waithelper;

import static org.thetestingacademy.driver.Drivermanager.getDriver;

public class LoginPage extends CommonToAllPage
{
    WebDriver driver;

    // Page Class

    // Step 0 -  Param Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Step 1- Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");
    // If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");

    // Step 2 - Page Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd)
    {
       openVWOUrl();
       enterInput(username,user);
       enterInput(password,pwd);
       clickElement(signButton);
       waithelper.checkVisibility(getDriver(),error_message);
      return getText(error_message);
    }

}

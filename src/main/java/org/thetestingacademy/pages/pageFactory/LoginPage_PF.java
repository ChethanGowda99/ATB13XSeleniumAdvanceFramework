package org.thetestingacademy.pages.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.thetestingacademy.base.CommonToAllPage;
import org.thetestingacademy.utils.PropertiesReader;
import org.thetestingacademy.utils.waithelper;


public class LoginPage_PF extends CommonToAllPage
{

    WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(id = "js-notification-box-msg")
    private WebElement error_message;

    // Page Actions
    public String loginToVWOLoginInvalidCred() {

        try {
            openVWOUrl();
            enterInput(username, PropertiesReader.readKey("invalid_username"));
            enterInput(password, PropertiesReader.readKey("invalid_password"));
            clickElement(signButton);
            waithelper.waitJVM(5000);
        } catch (Exception e) {
            System.out.println("Elements Not found!");
        }
        return getText(error_message);

    }
}

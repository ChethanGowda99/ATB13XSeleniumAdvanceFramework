package org.thetestingacademy.tests.pageObjectModel.vwo;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.thetestingacademy.base.CommonToAll;
import org.thetestingacademy.driver.Drivermanager;
import org.thetestingacademy.pages.pageObjectmodel.vwo.LoginPage;
import org.thetestingacademy.utils.PropertiesReader;

import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWO_Login_01_Optimised extends CommonToAll
{
    @Owner("chethan")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {
        // Driver Manager Code - 1 - D
        //WebDriver driver = new ChromeDriver();
        // Page Class Code (POM Code) - 2 - Ls
        LoginPage loginPage = new LoginPage(Drivermanager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));


        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));






    }
}

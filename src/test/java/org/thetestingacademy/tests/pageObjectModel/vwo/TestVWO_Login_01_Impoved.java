package org.thetestingacademy.tests.pageObjectModel.vwo;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.thetestingacademy.base.CommonToAll;
import org.thetestingacademy.driver.Drivermanager;
import org.thetestingacademy.pages.pageObjectmodel.vwo.Improved_POM.LoginPage;
import org.thetestingacademy.utils.PropertiesReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWO_Login_01_Impoved extends CommonToAll
{
    private static final Logger logger = LogManager.getLogger(TestVWO_Login_01_Optimised.class);



    @Owner("chethan")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test

    public void test_negative_vwo_login() {
        // Driver Manager Code - 1 - D
        //WebDriver driver = new ChromeDriver();
        // Page Class Code (POM Code) - 2 - Ls
        logger.info("Starting the Testcases Page Object Model");
        LoginPage loginPage = new LoginPage(Drivermanager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        logger.info("Asserting the invalid credentials");
        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));
        

    }
}

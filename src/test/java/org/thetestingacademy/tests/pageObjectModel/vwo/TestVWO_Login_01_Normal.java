package org.thetestingacademy.tests.pageObjectModel.vwo;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.thetestingacademy.pages.pageObjectmodel.vwo.DashboardPage;
import org.thetestingacademy.pages.pageObjectmodel.vwo.LoginPage;
import org.thetestingacademy.utils.PropertiesReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWO_Login_01_Normal {
    //  D
    // L
    // V


    @Owner("chethan")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {
        // Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();
        // Page Class Code (POM Code) - 2 - Ls
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCreds("admin@ad.com","123");


        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

        driver.quit();




    }
    @Owner("PRAMOD")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        // Driver Manager Code - 1
        WebDriver driver = new ChromeDriver();

        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginValidCreds("Test@QA.com","Chethu@1999");
        DashboardPage dashBoardPage  = new DashboardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Qa");


        driver.quit();

    }


}


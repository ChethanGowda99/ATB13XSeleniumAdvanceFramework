package org.thetestingacademy.tests.pageObjectModel.vwo.DataDrivenTesting;

import org.thetestingacademy.base.CommonToAll;



import org.thetestingacademy.driver.Drivermanager;
import org.thetestingacademy.pages.pageObjectmodel.vwo.Improved_POM.LoginPage;
import org.thetestingacademy.utils.PropertiesReader;
import org.thetestingacademy.utilsexcel.UtilExcel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Data_Driven_Testing extends CommonToAll
{

    private static final Logger logger = LogManager.getLogger(Data_Driven_Testing .class);



    @Test(dataProvider = "getData")
    public void test_vwo_login(String email, String password) {

        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(Drivermanager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(email,password);

        // Assertions - 3 - V

        logger.info("Asserting the Invalid credentials");

        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));



    }




    @DataProvider
    public Object[][] getData(){
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        return UtilExcel.getTestDataFromExcel("sheet1");

    }
}
package org.thetestingacademy.tests.pageObjectModel.vwo;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.thetestingacademy.base.CommonToAll;
import org.thetestingacademy.listeners.RetryAnalyzer;

import static org.thetestingacademy.driver.Drivermanager.getDriver;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWO_Login_01_Retry extends CommonToAll
{
    private static final Logger logger = LogManager.getLogger(TestVWO_Login_01_Retry.class);

    @Owner("Chethan")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
//        Allure.addAttachment("Log output", "text/plain", "This is some log text");
        Assert.assertTrue(false);
    }
    @Owner("Chethan")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
       // new TakeScreenShot().takeScreenshot("testPass_1");
        Assert.assertTrue(true);
    }





}
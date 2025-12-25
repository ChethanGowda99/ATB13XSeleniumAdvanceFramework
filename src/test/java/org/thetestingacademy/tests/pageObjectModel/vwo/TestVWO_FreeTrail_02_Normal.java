package org.thetestingacademy.tests.pageObjectModel.vwo;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.thetestingacademy.pages.pageObjectmodel.vwo.FreeTrailPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWO_FreeTrail_02_Normal
{
    @Owner("chethan")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test

    public void test_negative_vwo_freetrial()
    {
        // Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();
        // Page Class Code (POM Code) - 2 - Ls
        FreeTrailPage fp=new FreeTrailPage(driver);
       String msg= fp.enterDetailsInvalid("abc@test.com");
        // Assertions - 3 - V
        assertThat(msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(msg,"The email address you entered is incorrect.");
        driver.quit();
    }
}

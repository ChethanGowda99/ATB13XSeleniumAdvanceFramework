package org.thetestingacademy.pages.pageObjectmodel.vwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.thetestingacademy.utils.waithelper;

public class FreeTrailPage
{
    WebDriver driver;
    public FreeTrailPage( WebDriver driver)
    {
        this.driver=driver;

    }
    private By email_input=By.id("page-v1-step1-email ");
    private By checkbox=By.id("page-free-trial-step1-cu-gdpr-consent-checkbox ");
    private By button=By.xpath("//button[text()=\"Create a Free Trial Account\"]");
    private By error_msg= By.xpath("//div[contains(@class,\"invalid-reason\")]");

    public String enterDetailsInvalid( String email)
    { driver.get("https://vwo.com/free-trial/");
        waithelper.waitJVM(10000);
      driver.findElement(email_input).sendKeys(email);
      driver.findElement(checkbox).click();
      driver.findElement(button);
      String error=driver.findElement(error_msg).getText();
      return error;
    }

}

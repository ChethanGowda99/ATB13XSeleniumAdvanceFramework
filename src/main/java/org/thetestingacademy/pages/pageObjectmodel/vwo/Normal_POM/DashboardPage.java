package org.thetestingacademy.pages.pageObjectmodel.vwo.Normal_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.thetestingacademy.utils.waithelper;

public class DashboardPage
{
    WebDriver driver;
    public DashboardPage(WebDriver driver  ){
        this.driver=driver;

    }

    private By userNameOnDashboard = By.xpath("//h6");
    public String loggedInUserName(){
        waithelper.waitJVM(10000);
        driver.get("https://app.vwo.com/#/dashboard");
        return driver.findElement(userNameOnDashboard).getText();
    }


}

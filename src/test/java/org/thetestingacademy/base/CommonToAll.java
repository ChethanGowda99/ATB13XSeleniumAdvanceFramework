package org.thetestingacademy.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.thetestingacademy.driver.Drivermanager;

public class CommonToAll
{
    @BeforeMethod
    public void setUp(){
        Drivermanager.init();
    }

    @AfterMethod
    public void tearDown(){
        Drivermanager.down();
    }
}

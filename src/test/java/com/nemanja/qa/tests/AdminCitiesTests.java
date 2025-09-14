package com.nemanja.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
    
    @Test (priority = 10)
    public void VisitsTheAdminCitiesPageAndListCities(){
        navPage.getLoginButton().click();
        loginPage.getMailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getAdminCitiesButton().click();
        Assert.assertTrue(driver.getCurrentUrl()
                          .contains("/admin/cities"),
                          "Url should contain '/admin/cities'");
    }
    
}

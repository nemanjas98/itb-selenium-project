package com.nemanja.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest{
    
    @Test (priority = 10)
    public void VisitsTheProfilePage(){
        navPage.getLoginButton().click();
        loginPage.getMailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getProfileButton().click();
        Assert.assertTrue(driver.getCurrentUrl()
                          .contains("/profile"),
                          "Url should contain '/profile'");
        profilePage.waitForPageToBeLoaded();
        Assert.assertTrue(profilePage.getMailInput()
                          .getAttribute("value")
                          .equals("admin@admin.com"),
                          "Value should be 'admin@admin.com'");
        navPage.getLogoutButton().click();
    }
}

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
    
    @Test (priority = 20)
    public void ChecksInputTypes(){
        navPage.getLoginButton().click();
        loginPage.getMailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getProfileButton().click();
        profilePage.waitForPageToBeLoaded();
        Assert.assertEquals(profilePage.getMailInput()
                            .getAttribute("type"),
                            "email",
                            "Value should be 'email'");
        Assert.assertFalse(profilePage.getMailInput()
                            .isEnabled(),
                            "Input should be disabled");
        Assert.assertEquals(profilePage.getNameInput()
                            .getAttribute("type"),
                            "text",
                            "Value should be 'text'");      
        Assert.assertEquals(profilePage.getCityInput()
                            .getAttribute("type"),
                            "text",
                            "Value should be 'text'");       
        Assert.assertEquals(profilePage.getCountryInput()
                            .getAttribute("type"),
                            "text",
                            "Value should be 'text'"); 
        Assert.assertEquals(profilePage.getTwitterUrlInput()
                            .getAttribute("type"),
                            "url",
                            "Value should be 'url'");         
        Assert.assertEquals(profilePage.getGitHubUrlInput()
                            .getAttribute("type"),
                            "url",
                            "Value should be 'url'");  
        Assert.assertEquals(profilePage.getPhoneInput()
                            .getAttribute("type"),
                            "tel",
                            "Value should be 'tel'");  
        navPage.getLogoutButton().click();
    }
   
}

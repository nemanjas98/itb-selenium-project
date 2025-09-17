package com.nemanja.qa.tests;

import org.openqa.selenium.Keys;
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
        
        profilePage.verifyInputTypes();
        Assert.assertFalse(profilePage.getMailInput()
                            .isEnabled(),
                            "Input should be disabled");  
        
        navPage.getLogoutButton().click(); 
    }
    
    @Test (priority = 30)
    public void EditsProfile(){
        navPage.getLoginButton().click();
        loginPage.getMailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getProfileButton().click();
        profilePage.waitForPageToBeLoaded();
        
        profilePage.setName("Nemanja Stojanovic");
        profilePage.setPhone("+381641234567");
        profilePage.selectCity("Bucaramanga");
        profilePage.setCountry("Spain");
        profilePage.setTwitterUrl("https://twitter.com/profile/test123");
        profilePage.setGitHubUrl("https://github.com/test123");
        profilePage.getSaveButton().click();
        
        Assert.assertTrue(messagePopUpPage.waitForResponsePopUp()
                          .isDisplayed(),
                          "Pop up should be displayed");
        Assert.assertTrue(messagePopUpPage.getTextMessageFromPopUp()
                          .getText()
                          .contains("Profile saved successfuly"),
                          "PopUp should contain 'Profile saved successfuly' text");
        profilePage.verifyInputValues();
        
        navPage.getLogoutButton().click();
    }
    
}

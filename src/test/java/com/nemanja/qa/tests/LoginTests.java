
package com.nemanja.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
    
    @Test (priority = 10)
    public void VisitsTheLoginPage() {
        navPage.getLanguageButton().click();
        navPage.getEnButton().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Url should contain '/login'");  
    }
       
    @Test (priority = 20)
    public void ChecksInputTypes(){
        navPage.getLoginButton().click();
        Assert.assertTrue(loginPage.getMailInput()
                           .getAttribute("type")
                           .equals("email"),
                           "Value for the type attribute should be email");
        Assert.assertTrue(loginPage.getPasswordInput()
                           .getAttribute("type")
                           .equals("password"),
                           "Value for the type attribute should be password");
    }
    
    @Test (priority = 30)
    public void DisplaysErrorsWhenUserDoesNotExist(){
        navPage.getLoginButton().click();
        loginPage.getMailInput().sendKeys("non-existing-user@gmail.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForErrorPopUp();
        Assert.assertTrue(messagePopUpPage.getTextMessageFromErrorPopUp()
                           .getText()
                           .contains("User does not exists"),
                           "PopUp should contain 'User does not exists' text");
        Assert.assertTrue(driver.getCurrentUrl()
                           .contains("/login"),
                           "Url should contain '/login'");
    }
}

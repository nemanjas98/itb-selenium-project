
package com.nemanja.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    
    @Test (priority = 10)
    public void VisitsTheSignupPage(){
        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl()
                          .contains("/signup"),
                          "Url should contain '/signup'");  
    }
    
    @Test (priority = 20)
    public void ChecksInputTypes(){
        navPage.getSignupButton().click();
        Assert.assertTrue(signupPage.getMailInput()
                          .getAttribute("type")
                          .equals("email"),
                          "email: Value for the type attribute should be email");
        Assert.assertTrue(signupPage.getPasswordInput()
                          .getAttribute("type")
                          .equals("password"),
                          "Password: Value for the type attribute should be password");
        Assert.assertTrue(signupPage.getConfirmPasswordInput()
                          .getAttribute("type")
                          .equals("password"),
                          "ConfirmPassword: Value for the type attribute should be password");   
    }
    
    @Test (priority = 30)
    public void DisplaysErrorsWhenUserAlreadyExists(){
        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl()
                          .contains("/signup"),
                          "Url should contain '/signup'");  
        signupPage.getNameInput().sendKeys("Another User");
        signupPage.getMailInput().sendKeys("admin@admin.com");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignupButton().click();
        Assert.assertTrue(messagePopUpPage
                          .getTextMessageFromErrorPopUp()
                          .getText()
                          .contains("E-mail already exists"),
                          "PopUp should contain 'E-mail already exists' text");
        Assert.assertTrue(driver.getCurrentUrl()
                          .contains("/signup"),
                          "Url should contain '/signup'");
        
    }
    
    @Test (priority = 40)
    public void Signup(){
        navPage.getSignupButton().click();
        signupPage.getNameInput().sendKeys("Nemanja Stojanovic");
        signupPage.getMailInput().sendKeys("nemanjast@itbootcamp.rs");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignupButton().click();
        messagePopUpPage.waitForVerifyAccountPopUp();
        Assert.assertTrue(messagePopUpPage
                          .getHeaderMessageFromVerifyPopUp()
                          .getText()
                          .contains("IMPORTANT: Verify your account"),
                          "PopUp should contain 'IMPORTANT: Verify your account' text");
        messagePopUpPage.getCloseButtonFromVerifyAccountPopUp().click();
        navPage.getLogoutButton().click();
    }
    
}

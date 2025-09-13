
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
    
}


package com.nemanja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    
    public WebElement getMailInput(){
        return driver.findElement(By.id("email"));
    }
    
    public WebElement getPasswordInput(){
         return driver.findElement(By.id("password"));
    }
    
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }
    
}


package com.nemanja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    public SignupPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    
    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }
    
    public WebElement getMailInput(){
        return driver.findElement(By.id("email"));
    }
    
    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }
    
    public WebElement getConfirmPasswordInput(){
        return driver.findElement(By.id("confirmPassword"));
    }
    
    public WebElement getSignupButton(){
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }
    
}

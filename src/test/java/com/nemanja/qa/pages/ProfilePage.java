package com.nemanja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    public ProfilePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    
    public WebElement getMailInput(){
        return driver.findElement(By.id("email"));
    }
    
    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }
    
    public WebElement getCityInput(){
        return driver.findElement(By.id("city"));
    }
    
    public WebElement getCountryInput(){
        return driver.findElement(By.id("country"));
    }
    
    public WebElement getTwitterUrlInput(){
        return driver.findElement(By.id("urlTwitter"));
    }
    
    public WebElement getGitHubUrlInput(){
        return driver.findElement(By.id("urlGitHub"));
    }

     public WebElement getPhoneInput(){
        return driver.findElement(By.id("phone"));
    }   
    
    public void waitForPageToBeLoaded(){
        wait.until(ExpectedConditions
                .elementToBeClickable(By.className("btnSave")));
    }
    
    
}

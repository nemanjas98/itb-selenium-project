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
    
    public void waitForPageToBeLoaded(){
        wait.until(ExpectedConditions
                .elementToBeClickable(By.className("btnSave")));
    }
    
    
}

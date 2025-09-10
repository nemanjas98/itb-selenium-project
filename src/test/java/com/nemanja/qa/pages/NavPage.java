
package com.nemanja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    public NavPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    
    public WebElement getHomeButton(){
        return driver.findElement(By.cssSelector("a[href='/home']"));
    }
    
    public WebElement getAboutButton(){
        return driver.findElement(By.cssSelector("a[href='/about']"));
    }
    
    public WebElement getProfileButton(){
        return driver.findElement(By.cssSelector("a[href='/profile']"));
    }
    
    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }
    
    public WebElement getAdminCitiesButton(){
        return driver.findElement(By.className("btnAdminCities"));
    }
    
    public WebElement getAdminUsersButton(){
        return driver.findElement(By.className("btnAdminUsers"));
    }
     
    public WebElement getSignupButton(){
        return driver.findElement(By.cssSelector("a[href='/signup']"));
     }
     
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("a[href='/login']"));
     }
    
    public WebElement getLogoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }
    
    public WebElement getLanguageButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    
    public WebElement getEnButton(){
        return driver.findElement(By.className("btnEN"));
    }
    
    public WebElement getEsButton(){
        return driver.findElement(By.className("btnES"));
    }
    
    public WebElement getFrButton(){
        return driver.findElement(By.className("btnFR"));
    }
    
    public WebElement getCnButton(){
        return driver.findElement(By.className("btnCN"));
    }
    
    public WebElement getUaButton(){
        return driver.findElement(By.className("btnUA"));
    }
}

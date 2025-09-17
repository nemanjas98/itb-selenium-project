
package com.nemanja.qa.pages;

import javax.print.DocFlavor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    
    public WebElement waitForResponsePopUp(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }
    
    public WebElement waitForErrorResponsePopUp(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
    }
    
    public WebElement getTextMessageFromErrorPopUp(){
        return driver.findElement(By.xpath("//*[contains(@class, 'error')]//li"));
    }
    
    public WebElement getCloseButtonFromErrorPopUp(){
        return driver.findElement(By.xpath("//*[contains(@class, 'error')]//button"));
    }
    
    public WebElement waitForVerifyAccountPopUp(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'dlgVerifyAccount')]/../..")));
    }
    
    public WebElement getHeaderMessageFromVerifyPopUp(){
        return driver.findElement(By.className("dlgVerifyAccount"));
    }
    
    public WebElement getCloseButtonFromVerifyAccountPopUp(){
        return driver.findElement(By.className("btnClose"));
    }
    
    public WebElement getTextMessageFromPopUp(){
        return driver.findElement(By.className("success"));
    }
    
    
}

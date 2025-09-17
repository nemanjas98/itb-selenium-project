package com.nemanja.qa.pages;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
    
    public void setName(String name){
        WebElement input = getNameInput();
        input.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        input.sendKeys(name);
    }
    
        public void setPhone(String phone){
        WebElement input = getPhoneInput();
        input.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        input.sendKeys(phone);
    }
    
        public void setCountry(String country){
        WebElement input = getCountryInput();
        input.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        input.sendKeys(country);
    }  
        
        public void setTwitterUrl(String twitterUrl){
        WebElement input = getTwitterUrlInput();
        input.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        input.sendKeys(twitterUrl);
    }      
        
        public void setGitHubUrl(String gitHubUrl){
        WebElement input = getTwitterUrlInput();
        input.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        input.sendKeys(gitHubUrl);
    }             
    
    public void selectCity(String cityName){
        WebElement input = getCityInput();
        input.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        input.sendKeys(cityName);
    
        List<WebElement> options = driver.findElements(By.cssSelector(".v-select-list [role='option'] .v-list-item__title"));
        for(WebElement option : options){
            if(option.getText().equalsIgnoreCase(cityName)){
                wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                break;
            }
        }
     }
    
    public void verifyInputTypes(){
        Map<WebElement, String> inputTypes = Map.of(
        getMailInput(), "email",
        getNameInput(), "text",
        getCityInput(), "text",
        getCountryInput(), "text",
        getTwitterUrlInput(), "url",
        getGitHubUrlInput(), "url",
        getPhoneInput(), "tel"                
        );
        
        for(Map.Entry<WebElement, String> entry : inputTypes.entrySet()){
            Assert.assertEquals(entry.getKey().getAttribute("type"),
                                entry.getValue(),
                                "Input type mismatch for element: " + entry.getKey());
        }
    }
    
}

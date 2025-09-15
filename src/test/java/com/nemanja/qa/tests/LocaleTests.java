
package com.nemanja.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{
    
    @Test (priority = 10)
    public void SetLocaleToES(){
        navPage.getLanguageButton().click();
        navPage.getEsButton().click();
        Assert.assertTrue(navPage.getHeaderText()
                          .equals("Página de aterrizaje"),
                          "Header text should be 'Página de aterrizaje'");
    }
    
    @Test (priority = 20)
    public void SetLocaleToEN(){
        navPage.getLanguageButton().click();
        navPage.getEnButton().click();
        Assert.assertTrue(navPage.getHeaderText()
                          .equals("Landing"),
                          "Header text should be 'Landing'");
    }
    
    @Test (priority = 30)
    public void SetLocaleToCN(){
        navPage.getLanguageButton().click();
        navPage.getCnButton().click();
        Assert.assertTrue(navPage.getHeaderText()
                          .equals("首页"),
                          "Header text should be '首页'");        
    }
    
    @Test (priority = 40)
    public void SetLocaleToFR(){
        navPage.getLanguageButton().click();
        navPage.getFrButton().click();
        Assert.assertTrue(navPage.getHeaderText()
                          .equals("Page d'atterrissage"),
                          "Header text should be 'Page d'atterrissage'");        
        
    }
    
    @Test (priority = 50)
    public void SetLocaleToUA(){
        navPage.getLanguageButton().click();
        navPage.getUaButton().click();
        Assert.assertTrue(navPage.getHeaderText()
                          .equals("Лендінг"),
                          "Header text should be 'Лендінг'");    
    }
    
}

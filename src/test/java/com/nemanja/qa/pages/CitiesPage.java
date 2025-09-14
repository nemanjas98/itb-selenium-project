
package com.nemanja.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    public CitiesPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    
    public WebElement getNewItemButton(){
        return driver.findElement(By.className("btnNewItem"));
    }
    
    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }
    
    public WebElement waitForCreateOrEditDialogToBeVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
    }
    
    public WebElement waitforDeleteDialogToBeVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-dialog--active")));
    }
    
    public WebElement getSaveButtonFromCreateOrEditDialog(){
        return driver.findElement(By.className("btnSave"));
    }
    
    public WebElement getDeleteButtonFromDeleteDialog(){
        return driver.findElement(By.xpath("//button[.//span[normalize-space(text())='Delete']]"));
    }
    
    public void waitForNumberOfRowsToBe(int rowNumber){
        wait.until(ExpectedConditions.numberOfElementsToBe
                 (By.xpath("//*[contains(@class, 'v-data-table__wrapper')]//tbody/tr"), rowNumber));
    }
    
    public String getDataFromTheTable(int rowNumber, int columnNumber) {
        try {
            String cellData = driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[" + columnNumber + "]")).getText();
            return cellData;
        } catch (NoSuchElementException e) {
            System.out.println("Requested row or column does not exist: row=" + rowNumber + ", column=" + columnNumber);
            return "null";
         }
    }
    
    public WebElement getEditButton(int rowNumber){
            return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//button[@id=('edit')]"));
    }
     
    public WebElement getDeleteButton(int rowNumber){
           return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//button[@id=('delete')]"));
    }
     
     public WebElement getCityNameInput(){
         return driver.findElement(By.id("name"));
     }
     
     
     
     
    
    
    
    
    
    
    
    
}

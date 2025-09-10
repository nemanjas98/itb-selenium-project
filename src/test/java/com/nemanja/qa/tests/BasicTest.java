package com.nemanja.qa.tests;

import com.nemanja.qa.pages.CitiesPage;
import com.nemanja.qa.pages.LoginPage;
import com.nemanja.qa.pages.MessagePopUpPage;
import com.nemanja.qa.pages.NavPage;
import com.nemanja.qa.pages.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class BasicTest {
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected SoftAssert softAssert = new SoftAssert();
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignupPage signupPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;

    
    @BeforeClass 
    public void setup() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	loginPage = new LoginPage(driver, wait);
        navPage = new NavPage(driver, wait);
        signupPage = new SignupPage(driver, wait);
        citiesPage = new CitiesPage(driver, wait);
        messagePopUpPage = new MessagePopUpPage(driver, wait);
        }
	
    @BeforeMethod
    public void beforeMethod() {
	driver.get(baseUrl); 
	}
	
    @AfterMethod
    public void afterMethod() {
	}
	
    @AfterClass
    public void afterClass() {
            driver.quit();
	}
    
}

package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import pages.QualtricsLogin;
import pages.WebBase;


public class LoginTest {
    //The test requires a WebDriver object
    WebDriver testdriver;
    //This tests requires the Qualtrics Login Page object
    QualtricsLogin ql;
    WebElement errorMessage;

    
    @BeforeTest
    public void SetUp(){
        testdriver = WebBase.init();
        ql = new QualtricsLogin(testdriver);
        errorMessage = testdriver.findElement(By.cssSelector("#errorBannerAuth .error_wrapper"));
    }

    @Test (priority = 1)
    public void invalidLogin() throws InterruptedException{
        ql.loginAction("usser","pass");
        Assert.assertTrue(errorMessage.isDisplayed());  
        
    }

    @AfterTest
    public void tearDown(){
        testdriver.close();
       testdriver.quit(); 
    }
    
}

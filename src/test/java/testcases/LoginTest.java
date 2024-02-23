package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.QualtricsLogin;
import pages.WebBase;


public class LoginTest {
    //

    //The test requires a WebDriver object
    WebDriver testdriver;
    //Create a WebDriverWait object
    WebDriverWait waitForElement;
    //This tests requires the Qualtrics Login Page object
    QualtricsLogin ql;
    WebElement errorMessage;

    
    @BeforeTest
    public void SetUp(){
        testdriver = WebBase.init();
        testdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        

        ql = new QualtricsLogin(testdriver);
    }   

    @Test (priority = 1)
    public void invalidLogin() throws InterruptedException{
        ql.loginAction("usser","pass");
        Thread.sleep(5000);
        //errorMessage = waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#errorBannerAuth .error_wrapper")));
        errorMessage = testdriver.findElement(By.cssSelector("#errorBannerAuth .error_wrapper"));
    
        Assert.assertTrue(errorMessage.isDisplayed());  
        
    }

    @AfterTest
    public void tearDown(){
        testdriver.close();
       testdriver.quit(); 
    }
    
}

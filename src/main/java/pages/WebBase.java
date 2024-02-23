package pages;

//Date:February 2024
//Author: Luis Jacinto
//This class will be used as Base Page Instance 

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebBase {
    /*Objects Required
    Static WebDriver Object
    Static browse String
    Static URL String
    */
    static WebDriver baseWebDriver;
    static String browserName="chrome";
    static String url = "https://qualtricsxmp892d7mfr.az1.qualtrics.com/login";

    //Static init function, so is not required to instance a new object

    public static WebDriver init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeTestOptions= new ChromeOptions();
        //Chrome options prevents  an http client issue at run time
        chromeTestOptions.addArguments("--remote-allow-origins=*");
        baseWebDriver = new ChromeDriver(chromeTestOptions);
        baseWebDriver.manage().deleteAllCookies();
        baseWebDriver.manage().window().maximize();
        baseWebDriver.get(url);
        return baseWebDriver;

    }


}

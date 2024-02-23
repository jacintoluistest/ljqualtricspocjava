package pages;


// This page is the Qualtrics Login Representation as Java Class for POM design pattern


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QualtricsLogin {

    // The constructor class requires a WebDriver object
    public QualtricsLogin(WebDriver driver){
        //Initalize web elements
        //Page Factory class allows to use @FindBy annotation to set up Web Elements
        PageFactory.initElements(driver, this);
    }

    WebDriver testDriver;
    public Boolean isErrorMessagePresent;
    
    //Web elements set up

    //Qualtrics MX Logo 
    @FindBy(css ="login_form:nth-child(2) .bLogo")
    private WebElement qualtricsLogo;

    //Username input
    @FindBy(id="UserName")
    private WebElement userNameInput;
    
    //Password input
    @FindBy(id="UserPassword")
    private WebElement passwordInput;

    //Sign In Button

    @FindBy(id="loginButton")
    private WebElement loginButton;
    //Error pass message
    @FindBy(css="#errorBannerAuth .error_wrapper")
    private WebElement errorLoginMessage;


    public void loginAction(String user, String password){
        userNameInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.click();
        
    }

}




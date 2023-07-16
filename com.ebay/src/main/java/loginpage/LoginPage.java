package loginpage;

import base.BasePage;
import homepage.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

   @FindBy(xpath = "//input[@id='userid']")
    public WebElement emailInputField;
    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement passwordInputField;

    @FindBy(xpath = "//button[@id='sgnBt']")
    public WebElement signInButton;
    public void enterEmailAddress(String emailAddress){
        sendKeysToElement(emailInputField, emailAddress);
    }
    public void clickOnContinueButton(){
        safeClickOnElement(continueButton);
    }

    public void enterPassword(String password){
        sendKeysToElement(passwordInputField,password);
    }
    public void clickOnSignInButton(){
        safeClickOnElement(signInButton);
    }

    public HomePage doSignIn(String emailAddress, String password){
        enterEmailAddress(emailAddress);
        clickOnContinueButton();
        enterPassword(password);
        clickOnSignInButton();
        return new HomePage();

    }

}



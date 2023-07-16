package authentication;

import base.BasePage;
import homepage.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
   @FindBy(xpath="//input[@id='loginFormEmailInput']")
    public WebElement inputEmailField;

    @FindBy(xpath="//*[@id=\"loginFormSubmitButton\"]")
    public WebElement continueButton;

    @FindBy(xpath="//*[@id=\"passwordButton\"]")
    public WebElement enterPasswordInsteadButton;

    @FindBy(xpath="//input[@id='enterPasswordFormPasswordInput']")
    public WebElement passwordInputField;

    @FindBy(xpath="//button[@id='enterPasswordFormSubmitButton']")
    public WebElement submitButton;


    public void enterEmailAddress(String email){
        sendKeysToElement(inputEmailField,email);
    }
    public void clickOnContinueButton(){
        jsClickOnElement(continueButton);
    }
    public void clickOnEnterPasswordOption(){
        safeClickOnElement(enterPasswordInsteadButton);
    }

    public void enterPassword(String password){
        sendKeysToElement(passwordInputField,password);
    }
    public void clickOnSubmitButton(){
        safeClickOnElement(submitButton);
    }


    public HomePage doSignIn(String email, String password){
        enterEmailAddress(email);
        clickOnContinueButton();
        clickOnEnterPasswordOption();
        enterPassword(password);
        clickOnSubmitButton();


        return new HomePage();
    }

}


package homepage;

import base.BasePage;
import loginpage.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resultpage.ResultPage;
public class HomePage  extends BasePage {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='gh-ac']")
    public WebElement searchBar;
    @FindBy(xpath = "//input[@id='gh-btn']")
    public WebElement searchButton;
    @FindBy(xpath = "//span[@id='gh-ug']/a[.='Sign in']")
    public WebElement signInLink;

    @FindBy(xpath = "//button[@id='gh-ug'])")
    public WebElement welcomeMessage;

    public void enterSearchTerm(String searchTerm){
        sendKeysToElement(searchBar, searchTerm);
    }
    public void clickOnSearchButton(){
        safeClickOnElement(searchButton);
    }

    public ResultPage doSearch(String searchTerm){
        enterSearchTerm(searchTerm);
        clickOnSearchButton();
        return new ResultPage();
    }

    public LoginPage clickOnSignInLink(){
        safeClickOnElement(signInLink);
        return new LoginPage();
    }

}





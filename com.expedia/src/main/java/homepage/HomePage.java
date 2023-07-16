package homepage;

import base.BasePage;
import feedbackpage.FeedBackPage;
import flightsearchpage.FlightSearchPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[.='Sign in']")
    public WebElement signInLink;

    @FindBy(xpath ="//*[@id=\"app-layer-base\"]/div[1]/div[1]/header/div/section/div/div/div[2]/div[2]/div/div/div/div[3]/a")
    public WebElement signInButton1;
    @FindBy(xpath = "//span[.='Flights']")
    public WebElement flightsButton;

    @FindBy(xpath="//button[@aria-label='Leaving from']")
    public WebElement leavingFromInputBox;

    @FindBy(xpath="//button[@aria-label='Algiers, Algeria (ALG-Houari Boumediene)']")
    public WebElement airportOption;
    @FindBy(xpath = "//button[@aria-label='Going to']")
    public WebElement goingToInputBox;

    @FindBy(xpath = "//button[@aria-label='San F, California, United States of America']")
    public WebElement arrivalAirport;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    public WebElement searchButton;
    @FindBy(xpath="//div[contains(text(),'English')]")
    public WebElement englishButton;

    @FindBy(xpath = "//select[@id='language-selector']")
    public WebElement languageDropDown;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'Español')]")
    public WebElement spanishLanguageButton;

    @FindBy(xpath="//a[normalize-space()='Feedback']")
    public WebElement feedbackButton;

    @FindBy(xpath = "//a[normalize-space()='Jobs']")
    public WebElement jobsButton;


    public void clickOnSignInLink(){
        safeClickOnElement(signInLink);
    }
    public void clickOnSignIButton1(){
        safeClickOnElement(signInButton1);
    }

    public void clickOnFlightButton(){
        safeClickOnElement(flightsButton);
    }
    public void clickOnLeavingFromInputBox(){
        safeClickOnElement(leavingFromInputBox);
    }
    public void enterDeparturePlace(String cityDeparture){
        sendKeysToElement(leavingFromInputBox,cityDeparture);
    }
    public void clickOnAirportOption(){
        safeClickOnElement(airportOption);
    }

    public void clickOnGoingToInput(){
        safeClickOnElement(goingToInputBox);
    }

    public void enterDestination(String cityArrival){
        sendKeysToElement(goingToInputBox,cityArrival);
    }
    public void clickOnArrivalAirport(){
        safeClickOnElement(arrivalAirport);
    }
    public void clickOnSearchButton(){
        safeClickOnElement(searchButton);
    }

    public FlightSearchPage doSearch(String cityDepart, String cityArrive){
        clickOnFlightButton();
        //clickOnLeavingFromInputBox();
        enterDeparturePlace(cityDepart);
        clickOnAirportOption();
        clickOnGoingToInput();
        enterDestination(cityArrive);
        clickOnArrivalAirport();
        clickOnSearchButton();
        return new FlightSearchPage();
    }

   // public SupportPage clickOnSupportButton(){
       // safeClickOnElement(supportButton);
      //  return new SupportPage();
   // }

    public void clickOnEnglish(){
        safeClickOnElement(englishButton);
    }
    public void selectFromLanguageDropDown(){
        selectFromDropdownByVisibleText(languageDropDown,"Español");
    }
    public void clickOnSaveButton(){
        safeClickOnElement(saveButton);
    }

    public void doSwitchLanguage(){
        clickOnEnglish();
        selectFromLanguageDropDown();
        clickOnSaveButton();

    }

    public FeedBackPage clickOnFeedBackButton(){
        safeClickOnElement(feedbackButton);
        return new FeedBackPage();
    }
    //public JobsPage clickOnJobsButton(){
      //  safeClickOnElement(jobsButton);
      //  return  new JobsPage();
    }
//}


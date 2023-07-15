package staysearchpage;

import base.BasePage;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaySearchPage extends BasePage {
    public StaySearchPage() {
        PageFactory.initElements(driver, this);
    }

   @FindBy(xpath = "//button[@aria-label='Going to']")
    public WebElement goingToButton;


    @FindBy(xpath = "//input[@placeholder='Going to']")
    public WebElement goingToTxtBox;

    @FindBy(xpath = "(//button[@data-stid='destination_form_field-result-item-button'])[1]")
    public WebElement selectFirstCity;


    @FindBy(xpath = "//button[@id='d1-btn']")
    public WebElement checkingDateFieldButton;

    @FindBy(xpath = "//button[@id='d2-btn']")
    public WebElement checkoutDateFieldButton;

    @FindBy(xpath = "//button[@data-stid='apply-date-picker']")
    public WebElement doneButton;

    @FindBy(xpath = "//button[@data-stid='open-room-picker']")
    public WebElement selectTravellerButton;

    @FindBy(xpath="//button[@data-testid='submit-button']")
    public WebElement searchButton;

    @FindBy(xpath = "//button[@data-stid='show-more-results']")
    public WebElement showMoreResults;

    @FindBy(xpath = "(//a[@data-stid='open-hotel-information'])[1]")
    public WebElement searchHotelData;

    public void selectDate(String date)
    {
        WebElement dateElement=driver.findElement(By.xpath("(//button[@data-day='"+date+"'])[1]"));
        clickOnElement(dateElement);

    }

    public void clickOnGoingToButton(){
        safeClickOnElement(goingToButton);
    }
    public void clickOnGoingToTxBox(){
        safeClickOnElement(goingToTxtBox);
    }
    public void enterCity(String goingToCity) {
        sendKeysToElement(goingToTxtBox, goingToCity);
    }
    public void clickOnFirstOption(){
        safeClickOnElement(selectFirstCity);
    }

    public void clickOnCheckingDate(){
        safeClickOnElement(checkingDateFieldButton);
    }

    public void clickOnDoneButton(){
        safeClickOnElement(doneButton);
    }
    public void clickOnCheckoutDateFieldButton(){
        safeClickOnElement(checkoutDateFieldButton);
    }

    public void clickOnSearchButton(){
        safeClickOnElement(searchButton);
    }
    public void searchFlight(String goingToCity,String fromDate,String toDate) {

        clickOnGoingToButton();
        clickOnGoingToTxBox();
        enterCity(goingToCity);
        clickOnFirstOption();
        clickOnCheckingDate();
        selectDate(fromDate);
        clickOnDoneButton();
        clickOnCheckoutDateFieldButton();
        selectDate(toDate);
        clickOnElement(doneButton);
        clickOnSearchButton();

    }

}

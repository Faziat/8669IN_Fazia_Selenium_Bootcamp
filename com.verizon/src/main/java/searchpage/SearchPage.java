package searchpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SearchPage extends BasePage {
    public SearchPage(){
        PageFactory.initElements(driver,this);
    }
  @FindBy(xpath = "//input[@id='search_box_gnav_input']")
    public WebElement inputSearchBox;
    @FindBy(xpath = "//div[@class='tile_container components__TileWrap-giTVpv cijoCv']//div[3]//div[.='Apple iPhone 14 Prepaid']")
    public WebElement productLink;

    @FindBy(xpath = "//button[@id='ATC-Btn']")
    public WebElement continueButton;

    @FindBy(xpath = "//iframe[@src='about:blank']")
    public WebElement iframe;
    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement zipCodeInputField;

    @FindBy(xpath = "//button[@class='defaultPrimaryCTA ']")
    public WebElement confirmLocationButton;

    @FindBy(xpath = "//iframe[@id='universal_pixel_xjq5euo']")
    public WebElement iframe2;

    @FindBy(xpath = "//button[@class='modalButton fontSize_12 NHaasDS55Rg background_FF onlyRightMargin margin8']")
    public WebElement newCustomerButton;
    @FindBy(xpath = "//span[.='has been added to cart.']")
    public WebElement confirmationText ;
    public void enterSearchTerm(String searchTerm){
        sendKeysToElement(inputSearchBox, searchTerm);
    }



    public void pressEnterKey(){
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSearchPage doSearch(String searchTerm){
        enterSearchTerm(searchTerm);
        pressEnterKey();
        return new ResultSearchPage();
    }

    public void clickOnProductLink(){
        safeClickOnElement(productLink);

    }
    public void clickOnContinueButton(){
        safeClickOnElement(continueButton);

    }

    public void enterZipCode(String zipCode){
        safeClickOnElement(zipCodeInputField);
        sendKeysToElement(zipCodeInputField,zipCode);
    }
    public void clickOnConfirmLocation(){
        safeClickOnElement(confirmLocationButton);

    }
    public void clickOnNewCustomer(){
        safeClickOnElement(newCustomerButton);
    }

    public void doAddToCart(String zipCode){
        clickOnProductLink();
        clickOnContinueButton();
        enterZipCode(zipCode);
        clickOnConfirmLocation();
        clickOnNewCustomer();


    }
}

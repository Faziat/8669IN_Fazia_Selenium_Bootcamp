package homepage;

import base.BasePage;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage  extends BasePage {
    public ContactUsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='q']")
    public WebElement searchBar;
    @FindBy(xpath="//button[@id='search-button']")
    public WebElement searchButton;

    @FindBy(xpath="//div[@id='aria-map-list-header']")
    public WebElement locationFound;



    public void enterZipOnSearchBar(String zipCode){
        sendKeysToElement(searchBar,zipCode);
    }
    public void clickOnSearchButton(){
        safeClickOnElement(searchButton);
    }
    public void doSearchAtmLocation(String zipCode){
        enterZipOnSearchBar(zipCode);
        clickOnSearchButton();
    }

}

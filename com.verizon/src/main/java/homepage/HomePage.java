package homepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import searchpage.SearchPage;
import storeslocationpage.StoresLocationPage;

public class HomePage extends BasePage {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
  @FindBy(xpath = "//button[@id='gnav20-search-icon']")
    public WebElement searchButton;
    @FindBy(xpath = "//div[@class='gnav20-row-one opacityOne']//a[contains(.,'Stores')]")
    public WebElement storesLink;

    public SearchPage clickOnSearchButton(){
        safeClickOnElement(searchButton);
        return new SearchPage();
    }

    public StoresLocationPage clickOnStoreLink(){
        safeClickOnElement(storesLink);
        return new StoresLocationPage();
    }
}

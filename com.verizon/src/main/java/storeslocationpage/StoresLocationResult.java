package storeslocationpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoresLocationResult extends BasePage {
    public StoresLocationResult(){
        PageFactory.initElements(driver,this);
    }
   @FindBy(xpath = "//div[@class='store-details p-2 mb-2 store-sm-0 store-sm-selected']//span[@class='HitArea-VDS__sc-bc3yhn-0 dCkSrl']")
    public WebElement viewStoreDetailButton;

    @FindBy(css = "#FavoriteUnSelected")
    public WebElement addToFavoriteIcon;
    @FindBy(xpath= "//span[@class='NotificationIconWrapper-VDS__sc-1383qpl-8 jkcrrZ']")
    public WebElement confirmationText;


    public void clickOnViewStoreDetailButton(){
        safeClickOnElement(viewStoreDetailButton);
    }
    public void clickOnAddToFavoriteIcon(){
        safeClickOnElement(addToFavoriteIcon);
    }

    public void doAddToFavorite(){
        clickOnViewStoreDetailButton();
        clickOnAddToFavoriteIcon();
    }
}

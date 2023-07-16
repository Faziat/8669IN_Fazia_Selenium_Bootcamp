package searchpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultSearchPage extends BasePage {
    public ResultSearchPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//div[@class='results']")
    public WebElement resultNumber;

    @FindBy(xpath = "//select[@class='SelectEl-VDS__sc-h8azzi-1 kVMokZ']")
    public WebElement sortByDropDown;
    @FindBy(xpath = "//h5[.='Color']")
    public WebElement colorDropDown;

    @FindBy(xpath = "//span[@class='ChildWrapper-VDS__sc-19df7fd-0 kSwbUn']//span[contains(.,'Black (8)')]")
    public WebElement optionBlackBox;
    @FindBy(xpath = "//button[@class='sc-gZMcBi iYWpSa']")
    public WebElement viewResultButton;

    public void selectOptionFromDropDown(){
        selectFromDropdownByVisibleText(sortByDropDown,"Highest Rating");
    }

    public void clickOnColorDropDown(){
        safeClickOnElement(colorDropDown);
    }
    public void checkOptionBlackBox(){
        safeClickOnElement(optionBlackBox);
    }

    public void clickOnViewResultButton(){
        safeClickOnElement(viewResultButton);
    }

    public void doSorting(){
        selectOptionFromDropDown();
        clickOnColorDropDown();
        checkOptionBlackBox();
        clickOnViewResultButton();
    }
}

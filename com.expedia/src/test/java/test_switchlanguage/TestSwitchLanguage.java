package test_switchlanguage;

import base.BasePage;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSwitchLanguage extends BasePage {
    public TestSwitchLanguage(){
        PageFactory.initElements(driver,this);
    }
   @Test(priority=6,groups={"Smoke"})
    public void testSwitchLanguage(){
       HomePage homePage=new HomePage();
        homePage.doSwitchLanguage();

        Assert.assertTrue(isElementVisible(homePage.spanishLanguageButton));
    }
}

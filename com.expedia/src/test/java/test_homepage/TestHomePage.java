package test_homepage;

import base.BasePage;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePage extends BasePage {
    public TestHomePage() {
        PageFactory.initElements(driver, this);
    }

   @Test(priority = 1)
    public void testNavigationToApplication() {
      HomePage homepage = new HomePage();

     Assert.assertTrue(isElementVisible(homepage.logo));

    }

}
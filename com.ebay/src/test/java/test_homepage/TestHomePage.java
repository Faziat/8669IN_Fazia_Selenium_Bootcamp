package test_homepage;

import base.BasePage;
import homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
    public class TestHomePage extends BasePage {
        @Test(priority = 1)
        public void testNavigationToApplication(){
            HomePage homePage=new HomePage();
            Assert.assertTrue(isElementVisible(homePage.searchButton));
        }
}

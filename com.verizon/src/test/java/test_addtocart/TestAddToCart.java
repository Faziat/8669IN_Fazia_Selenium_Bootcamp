package test_addtocart;

import base.BasePage;
import homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import searchpage.ResultSearchPage;
import searchpage.SearchPage;

public class TestAddToCart extends BasePage {
  @Test(priority = 1)

    public void testAddToCart() {
       HomePage homePage = new HomePage();
        SearchPage searchPage = homePage.clickOnSearchButton();
        String searchTerm="iPhone 14";
        ResultSearchPage resultSearchPage = searchPage.doSearch(searchTerm);
        resultSearchPage.doSorting();
        String zipCode="46074";
        searchPage.doAddToCart(zipCode);
        Assert.assertTrue(isElementVisible(searchPage.confirmationText));

    }
}

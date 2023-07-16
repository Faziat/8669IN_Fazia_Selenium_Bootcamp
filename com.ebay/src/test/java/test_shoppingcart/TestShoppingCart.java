package test_shoppingcart;
import base.BasePage;
import homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import resultpage.ResultPage;public class TestShoppingCart extends BasePage {
    @Test(priority = 5)

    public void testAddToCart() {
      HomePage homePage = new HomePage();
        String searchTerm="bird cage";
       ResultPage resultPage= homePage.doSearch(searchTerm);
        resultPage.doAddToCart();
        Assert.assertTrue(isElementVisible(resultPage.goToCheckoutButton));
    }
}


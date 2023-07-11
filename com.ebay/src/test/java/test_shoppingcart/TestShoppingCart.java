package test_shoppingcart;
import base.BasePage;
import homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import resultpage.ResultPage;public class TestShoppingCart extends BasePage {
    @Test(priority = 1, groups = {"BAT"})

    public void testAddToCart() {
      HomePage homePage = new HomePage();
        String searchTerm="baby shampoo";
       ResultPage resultPage= homePage.doSearch(searchTerm);
        resultPage.doAddToCart();
        Assert.assertTrue(isElementVisible(resultPage.goToCheckoutButton));
    }
}


package test_search;

import authentication.SignInPage;
import base.BasePage;
import homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import searchpage.ResultSearchPage;
import searchpage.SearchPage;
import utils.ExcelData;

public class TestSearch extends BasePage {
    /*Test case: Search
     *1. Navigate to the Apartments.com homepage
     *2. Log in to Apartments.com with a valid user account
     *3.Enter a specific location, such as a city or ZIP code, in the search bar.
     *4.Set search filters, such as price range, number of bedrooms, and amenities
     *5.Verify that the search results are displayed correctly based on the specified criteria

     */

    @Test(priority= 3, groups= {"BAT"},dataProvider = "searchDataProvider")

    public void testDoSearch(String searchTerm){
        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        SearchPage searchPage= new SearchPage();
        ResultSearchPage resultSearchPage= new ResultSearchPage();

        homePage.clickOnSignInLink();
        String email="abc1@gmail.com";
        String password="AydenLiam1213";

        signInPage.doSignIn(email,password);

        searchPage.searchTerm(searchTerm);
        resultSearchPage.doSearch();


        Assert.assertTrue(isElementVisible(resultSearchPage.searchResult));

    }
    @DataProvider(name="searchDataProvider")
    public Object[][] searchDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("doSearch");
        return data;

    }

    /* Test Case Add to favorites
     *1. Log in to Apartments.com with a valid user account.
     *2. Browse through property listings and click on the "Add to Favorites" button for a few properties.
     *3.Go to the "Favorites" section in your account.
     *4.Verify that the favorite properties are displayed correctly and can be accessed from this section.

     */

    @Test(priority= 4, groups= {"BAT"})
    public void testAddToFavorite(){
        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        SearchPage searchPage= new SearchPage();
        ResultSearchPage resultSearchPage= new ResultSearchPage();


        homePage.clickOnSignInLink();
        String email="abc1@gmail.com";
        String password="AydenLiam1213";

        signInPage.doSignIn(email,password);
        String searchTerm="19130 PA, Philadelphia";
        searchPage.searchTerm(searchTerm);
        resultSearchPage.doSearch();
        resultSearchPage.clickOnHearts();
        Assert.assertTrue(isElementVisible(resultSearchPage.favoriteResult));

    }
}
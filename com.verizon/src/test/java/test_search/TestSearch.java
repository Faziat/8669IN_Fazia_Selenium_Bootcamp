package test_search;

import base.BasePage;
import homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import searchpage.ResultSearchPage;
import searchpage.SearchPage;
import utils.ExcelData;

public class TestSearch extends BasePage {
    @Test(priority = 2, dataProvider = "searchDataProvider")

    public void testSearch(String searchTerm){
      HomePage homePage = new HomePage();
        SearchPage searchPage= homePage.clickOnSearchButton();
      ResultSearchPage resultSearchPage=searchPage.doSearch(searchTerm);
        Assert.assertTrue(isElementVisible(resultSearchPage.resultNumber));

    }

   @DataProvider (name = "searchDataProvider")
    public String[][] searchDataProvider() {

        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\test_data.xlsx";
      ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("doSearch");
        return data;

    }
}

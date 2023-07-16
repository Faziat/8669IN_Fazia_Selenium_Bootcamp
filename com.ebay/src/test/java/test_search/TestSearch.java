package test_search;

import base.BasePage;
import homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import searchpage.SearchResultsPage;
import utils.ExcelData;

public class TestSearch extends BasePage {
    @Test(priority = 3,dataProvider = "searchDataProvider")
    public void testDoSearch (String searchTerm){
        HomePage homepage = new HomePage();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        homepage.doSearch(searchTerm);
        Assert.assertTrue(isElementVisible(searchResultsPage.resultsNumber));

    }
    @DataProvider(name = "searchDataProvider")
    public String[][] searchDataProvider() {

        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("doSearch");
        return data;
    }

}

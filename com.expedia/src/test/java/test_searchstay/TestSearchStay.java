package test_searchstay;

import base.BasePage;
import homepage.HomePage;
import staysearchpage.StaySearchPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;
public class TestSearchStay extends BasePage {

    @Test(priority= 5,dataProvider = "searchFlightDataProvider")

    public void testSearchFlightData(String goingToCity,String fromDate,String toDate){

       StaySearchPage flightSearchPage=new StaySearchPage();
       flightSearchPage.searchFlight(goingToCity,fromDate,toDate);
        Assert.assertTrue(isElementVisible(flightSearchPage.searchHotelData));

    }
    @DataProvider(name="searchFlightDataProvider")
    public String[][] searchFlightsDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("dosearch");
        return data;

    }

}
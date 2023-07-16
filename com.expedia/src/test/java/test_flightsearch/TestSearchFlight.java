package test_flightsearch;
import base.BasePage;
import flightsearchpage.FlightSearchPage;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchFlight extends BasePage {
    public TestSearchFlight(){
        PageFactory.initElements(driver,this);
    }
   @Test(priority = 4,groups={"Smoke"})

    public void testDoSearchFlight(){
   HomePage homePage=new HomePage();
        String cityA="Algeria";
        String cityB="California";
      FlightSearchPage flightSearchPage= homePage.doSearch(cityA,cityB);
       Assert.assertTrue(isElementVisible(flightSearchPage.resultText));
    }
}

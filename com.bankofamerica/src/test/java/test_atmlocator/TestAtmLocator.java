package test_atmlocator;

import atmpage.AtmLocationPage;
import bankofamericapage.BankOfAmericaPage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestAtmLocator extends BasePage {
    @Test(priority = 1, dataProvider = "searchAtmLocationDataProvider")

    public void testSearchAtmLocator(String zipCode) {

        BankOfAmericaPage bankOfAmericaPage = new BankOfAmericaPage();
      AtmLocationPage atmLocationPage=bankOfAmericaPage.clickOnFindAtmLink();
        atmLocationPage.doSearchAtmLocation(zipCode);
      Assert.assertTrue(isElementVisible(atmLocationPage.locationFound));

    }
    @DataProvider(name = "searchAtmLocationDataProvider")
    public String[][] searchAtmDataProvider()
    {

        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\test_data.xlsx";
       ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("doSearchAtmLocation");
        return data;

    }
    @Test(priority = 2, groups = {"BAT"}, dataProvider = "searchAtmLocationInvalidZipDataProvider")

    public void testSearchAtmLocatorWithInvalidZip(String zipCode) {

        BankOfAmericaPage bankOfAmericaPage = new BankOfAmericaPage();
        AtmLocationPage atmLocationPage=bankOfAmericaPage.clickOnFindAtmLink();
        atmLocationPage.doSearchAtmLocation(zipCode);
        Assert.assertTrue(isElementVisible(atmLocationPage.locationFound));

    }

    @DataProvider(name = "searchAtmLocationInvalidZipDataProvider")
    public String[][] searchAtmInvalidZipDataProvider()
    {

        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("invalidZip");
        return data;

    }
}



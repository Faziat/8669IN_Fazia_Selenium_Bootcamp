package test_accountsettings;

import accountsettingspage.AccountSettingPage;
import authentication.SignInPage;
import base.BasePage;
import homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import searchpage.ResultSearchPage;
import searchpage.SearchPage;
import utils.ExcelData;

public class TestAccountSettings extends BasePage {


    @Test(priority = 5, groups = {"BAT"})
    public void testAccountSettings() {
        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        AccountSettingPage accountSettingPage= new AccountSettingPage();

        homePage.clickOnSignInLink();
        String email = "toubouachefazia@gmail.com";
        String password = "Fazia@96us";

        signInPage.doSignIn(email, password);
        homePage.hoverClickOnAccount();
        String phoneNumber = "223-334-5589";
        String streetAddress = "1277 Ritchie dr";
        String city ="Indiana";

        accountSettingPage.doSaveChanges(phoneNumber,streetAddress, city);

    }
    @Test(priority= 2,dataProvider = "accountSettingsDataProvider")

    public void testDoSaveUpdates(String phoneNumber,String streetAddress,String city){
        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        AccountSettingPage accountSettingPage= new AccountSettingPage();

        homePage.clickOnSignInLink();
        String email = "toubouachefazia@gmail.com";
        String password = "Fazia@96us";

        signInPage.doSignIn(email, password);
        homePage.hoverClickOnAccount();
        accountSettingPage.doSaveChanges(phoneNumber,streetAddress, city);

    }
    @DataProvider(name="accountSettingsDataProvider")
    public Object[][] accountSettingDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("doSaveUpdates");
        return data;

    }

}
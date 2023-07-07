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

    /*
     * Test Case: Account Settings
     *1.Log in to Apartments.com with a valid user account.
     *2.Navigate to the "Account Settings" or "Profile" section
     *3.Update one or more user profile fields, such as name, email, or phone number
     *4.Save the changes.
     *6.Verify that the updated information is reflected correctly in your account
     * */
    @Test(priority = 5, groups = {"BAT"})
    public void testAccountSettings() {
        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        AccountSettingPage accountSettingPage= new AccountSettingPage();

        homePage.clickOnSignInLink();
        String email = "abc1@gmail.com";
        String password = "AydenLiam1213";

        signInPage.doSignIn(email, password);
        homePage.hoverClickOnAccount();
        String phoneNumber = "2679342174";
        String streetAddress = "123 Main st";
        String city ="New York";

        accountSettingPage.doSaveChanges(phoneNumber,streetAddress, city);

    }
    @Test(priority= 6, groups= {"BAT"},dataProvider = "accountSettingsDataProvider")

    public void testDoSaveUpdates(String phoneNumber,String streetAddress,String city){
        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        AccountSettingPage accountSettingPage= new AccountSettingPage();

        homePage.clickOnSignInLink();
        String email = "abc1@gmail.com";
        String password = "AydenLiam1213";

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
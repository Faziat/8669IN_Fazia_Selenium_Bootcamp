package test_authentication;

import base.BasePage;
import homepage.HomePage;
import loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestAuthentication extends BasePage {
    @Test(priority= 1, groups= {"BAT"},dataProvider = "loginDataProvider")

    public void testLogin(String email,String pass){
       HomePage homePage = new HomePage();
       LoginPage loginPage= homePage.clickOnSignInLink();
        loginPage.doSignIn(email, pass);
        Assert.assertTrue(isElementVisible(homePage.welcomeMessage));
    }
  @DataProvider(name="loginDataProvider")
    public String[][] loginDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
       ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("doSignIn");
        return data;

    }
}

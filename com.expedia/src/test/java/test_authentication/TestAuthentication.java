package test_authentication;

import authentication.LoginPage;
import base.BasePage;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestAuthentication extends BasePage {
    public TestAuthentication(){
        PageFactory.initElements(driver,this);

    }
   @Test(priority= 2, groups= {"BAT"},dataProvider = "logindataprovider")
   public void testLogin(String email, String password) {
       HomePage homePage = new HomePage();
       LoginPage loginPage = new LoginPage();

       homePage.clickOnSignInLink();
       homePage.clickOnSignIButton1();
       loginPage.doSignIn(email, password);
   }
   @DataProvider(name="logindataprovider")
    public String[][] loginDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
      ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("doSignIn");
        return data;

    }
}


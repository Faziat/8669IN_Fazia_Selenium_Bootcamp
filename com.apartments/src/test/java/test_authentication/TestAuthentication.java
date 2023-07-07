package test_authentication;

import authentication.SignInPage;
import base.BasePage;
import homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestAuthentication extends BasePage {

    /* Test Case :Sign In to Apartments.com
     * 1.Navigate to URl "www.apartments.com"
     * 2.Click on the "Sign In" button/link.
     * 3.Enter a valid email address in the email input field
     * 4.Enter a valid password in the password input field.
     * 5.Click on the "Sign In" button
     * 6.Verify that the user is successfully logged in and redirected to the home page.
     *  */

    @Test(priority = 1, groups = "BAT")

    public void testDoSignIn() {

        HomePage homePage = new HomePage();

        homePage.clickOnSignInLink();
        ExcelData excelData = new ExcelData(BasePage.DATA_PATH);
        SignInPage signInPage = new SignInPage();
        String[][] credentials = excelData.readStringArrays("doSignIn");
        String email = credentials[0][0];
        String password = credentials[0][1];

        signInPage.doSignIn(email, password);


        Assert.assertTrue(checkElementPresent (homePage.userName));
    }


    @Test(priority= 1, groups= {"BAT"},dataProvider = "signInDataProvider")
    public void testUserSignIn(String email,String password){
        SignInPage signInPage = new SignInPage();
        HomePage homePage = new HomePage();
        homePage.clickOnSignInLink();

        signInPage.doSignIn(email,password);
        Assert.assertTrue(checkElementPresent(homePage.loggedInUsername));
    }

    @DataProvider(name="signInDataProvider")
    public Object[][] testSignInUserDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("doSignIn");
        return data;

    }


    /* Test Case :Sign Out to Apartments.com
     * 1.Navigate to URl "www.apartments.com"
     * 2.Click on the "Sign In" button/link.
     * 3.Enter a valid email address in the email input field
     * 4.Enter a valid password in the password input field.
     * 5.Click on the "Sign In" button
     * 6.Verify that the user is successfully logged in and redirected to the home page.
     * 7.Hover over the username located in the header manu
     * 8.Click on the "Sign Out" link
     * 9.Verify that you are redirected to the homepage or a login page.
     *
     *  */

    @Test(priority = 2, groups={"BAT"}, dataProvider = "signOutDataProvider")

    public void testLogOut(String email,String pass){
        HomePage homePage= new HomePage();
        SignInPage signInPage = new SignInPage();


        homePage.clickOnSignInLink();


        signInPage.doSignIn(email,pass);
        homePage.doSignOut();

        Assert.assertTrue(isElementVisible(homePage.signInLink));
    }
    @DataProvider(name="signOutDataProvider")
    public Object[][] testSignOutDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("doSignIn");
        return data;

    }

}








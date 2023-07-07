package test_resetpassword;

import authentication.SignInPage;
import base.BasePage;
import homepage.HomePage;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestResetPassword extends BasePage {

    /**
     * Test Case:Password Reset
     *1.Navigate to the Apartments.com login page.
     *2.Click on the "Forgot Password" link.
     *3.Enter the email associated with your account and submit the form.
     *4.Check your email for a password reset link.
     *5.Click on the reset link and follow the instructions to reset your password.
     *6.Verify that you can log in successfully using the new password.
     */


    @Test(priority = 7, groups={"BAT"})
    public void testResetPassword(){


        HomePage homePage = new HomePage();

        homePage.clickOnSignInLink();
        ExcelData excelData = new ExcelData(BasePage.DATA_PATH);
      SignInPage signInPage = new SignInPage();
        String[][] credentials = excelData.readStringArrays("doSignIn");
        String email = credentials[0][0];
        String password = credentials[0][1];

        signInPage.doSignIn(email, password);

    }
}


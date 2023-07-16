package test_contactus;

import base.BasePage;
import conatctuspage.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactUs extends BasePage {
    @Test(priority = 4 )
    public void testContactUs(){
       ContactUsPage contactUsPage= new ContactUsPage();
        String name= "Fazia";
        String email="tf@gmail.com";
        String phoneNumber= "2098889997";
        String comment= " Hello fazia ";
        contactUsPage.doContactUs(name,email,phoneNumber,comment);

        Assert.assertTrue(isElementVisible(contactUsPage.thankYouForContactingUsMessage));
    }
}

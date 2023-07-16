package test_feedback;

import base.BasePage;
import feedbackpage.FeedBackPage;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFeedBack extends BasePage {
    public TestFeedBack(){
        PageFactory.initElements(driver,this);
    }
 @Test(priority = 3,groups={"Smoke"})

    public void testFeedBck(){
      HomePage homePage=new HomePage();
       FeedBackPage feedBackPage= homePage.clickOnFeedBackButton();

        String text="i like this app ";
        feedBackPage.doFeedBack(text);

      Assert.assertTrue(isElementVisible(feedBackPage.thankYouMessage));
    }
}



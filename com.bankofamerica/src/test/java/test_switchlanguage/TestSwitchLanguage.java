package test_switchlanguage;

import bankofamericapage.BankOfAmericaPage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSwitchLanguage extends BasePage {
   @Test(priority =3)
    public void switchLanguages(){
      BankOfAmericaPage bankOfAmericaPage= new BankOfAmericaPage();
        bankOfAmericaPage.doSwitchLanguages();
        Assert.assertTrue(isElementVisible(bankOfAmericaPage.languageButton));
    }

}

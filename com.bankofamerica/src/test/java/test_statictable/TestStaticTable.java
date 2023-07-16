package test_statictable;

import base.BasePage;
import homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStaticTable extends BasePage {
    @Test(priority = 4)
    public void testStaticTable() {


        HomePage homePage = new HomePage();
        Assert.assertTrue(isElementVisible(homePage.tableForBoa));

        int expectedRowCount = 1;
        Assert.assertEquals(expectedRowCount,homePage.getRowCount());

        int rowIndex = 1;
        int expectedCellCount = 1;

    }
}




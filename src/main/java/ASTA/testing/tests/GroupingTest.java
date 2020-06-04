package ASTA.testing.tests;

import ASTA.testing.pages.DashBoardPage;
import ASTA.testing.utils.BaseProperties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupingTest extends DefaultTest {

    @Test
    public void groupItemTest() {
        Assert.assertTrue(new DashBoardPage(driver)
                .openGroupPage()
                .filterItems(BaseProperties.GROUPIMG_FILTER)
                .checkIfFiltered(BaseProperties.GROUPIMG_FILTER));
    }
}

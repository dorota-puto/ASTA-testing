package ASTA.testing.tests;

import ASTA.testing.pages.DashBoardPage;
import ASTA.testing.utils.BaseProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupingTest extends DefaultTest {

    @Test
    public void groupItemTest() {
        Assert.assertTrue(new DashBoardPage(driver)
                .openGroupPage()
                .filterItems(BaseProperties.GROUPING_FILTER)
                .checkIfFiltered(BaseProperties.GROUPING_FILTER));
    }
}

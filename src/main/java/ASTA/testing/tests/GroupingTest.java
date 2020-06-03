package ASTA.testing.tests;

import ASTA.testing.pages.DashBoardPage;
import ASTA.testing.utils.BaseProperties;
import org.testng.annotations.Test;

public class GroupingTest extends DefaultTest {

    @Test
    public void groupItemTest() {
        new DashBoardPage(driver)
                .openGroupPage()
                .filterItems(BaseProperties.FILTER);
    }
}

package ASTA.testing.tests;

import ASTA.testing.pages.DashBoardPage;
import ASTA.testing.utils.BaseProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketTest extends DefaultTest {

    @Test
    public void addToBasketTest() {

        Assert.assertTrue(new DashBoardPage(driver)
                .openBasketPage()
                .addToBasket(BaseProperties.COUNT, BaseProperties.BASKET_FILTER)
                .addToBasket(5, "Kabel")
                .isBasketWellCounted());
    }
}

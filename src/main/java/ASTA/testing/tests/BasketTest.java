package ASTA.testing.tests;

import ASTA.testing.pages.BasketPage;
import ASTA.testing.pages.DashBoardPage;
import ASTA.testing.utils.BaseProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class BasketTest extends DefaultTest {

    @Test
    public void addToBasketTest() {
        Assert.assertTrue(new DashBoardPage(driver)
                .openBasketPage()
                .addToBasket(BaseProperties.COUNT, Objects.requireNonNull(BasketPage.filterProduct(BaseProperties.BASKET_FILTER, BaseProperties.COUNT)))
                .addToBasket(5, Objects.requireNonNull(BasketPage.filterProduct("Kabel", 5)))
                .isBasketWellCounted());
    }
}

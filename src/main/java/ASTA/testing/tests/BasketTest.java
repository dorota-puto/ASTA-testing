package ASTA.testing.tests;

import ASTA.testing.pages.BasketPage;
import ASTA.testing.pages.DashBoardPage;
import ASTA.testing.utils.BaseProperties;
import ASTA.testing.utils.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static ASTA.testing.utils.BaseProperties.BASKET_DATA_SHEET;
import static ASTA.testing.utils.BaseProperties.DATA_FILE_NAME;

public class BasketTest extends DefaultTest {

    @DataProvider(name = "basketData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {
                        asMap(ExcelUtility.getTestData("testCase1"))
                },
                {
                        asMap(ExcelUtility.getTestData("testCase2"))
                }
        };
    }

    private Map<String, Integer> asMap(String[][] testCase) {
        Map<String, Integer> result = new HashMap<>();

        for (String[] strings : testCase) {
            result.put(strings[0], Integer.parseInt(strings[1]));
        }
        return result;
    }

    @BeforeClass
    public void setUpMethod() {
        try {
            ExcelUtility.setExcelFile(customFile.getResourceFilePath(DATA_FILE_NAME), BASKET_DATA_SHEET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "basketData")
    public void addToBasketTest(Map<String, Integer> productToCounts) {

        Assert.assertTrue(new DashBoardPage(driver)
                .openBasketPage()
                .cleanBasket()
                .addToBasket(productToCounts)
                .isBasketWellCounted());
    }
}

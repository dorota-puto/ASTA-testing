package ASTA.testing.tests;

import ASTA.testing.pages.DashBoardPage;
import ASTA.testing.utils.BaseProperties;
import ASTA.testing.utils.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;

public class FormTest extends DefaultTest {

    @DataProvider(name = "formData")
    public Object[][] dataProvider() {
        return ExcelUtility.getTestData("valid");
    }

    @BeforeClass
    public void setUpMethod() {
        try {
            ExcelUtility.setExcelFile(customFile.getResourceFilePath(BaseProperties.DATA_FILE_NAME), BaseProperties.FORM_DATA_SHEET);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void returnHome() {

        String parentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.close();
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.navigate().back();
    }

    @Test(dataProvider = "formData")
    public void fillFormTest(String name, String email, String phone) {

        Assert.assertTrue(
                new DashBoardPage(driver).openFormPage()
                        .openApplyFormPage()
                        .fillApplyForm(name, email, phone)
                        .submitForm()
                        .isConfirmMessageDisplayed());
    }
}

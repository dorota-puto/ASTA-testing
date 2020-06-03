package ASTA.testing.tests;

import ASTA.testing.pages.DashBoardPage;
import ASTA.testing.utils.BaseProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends DefaultTest {

    @Test
    public void fillFormTest() {

        Assert.assertTrue(
                new DashBoardPage(driver).openFormPage()
                        .openApplyFormPage()
                        .fillApplyForm(BaseProperties.APPLICANT_NAME,
                                BaseProperties.APPLICANT_EMAIL,
                                BaseProperties.APPLICANT_PHONE)
                        .submitForm()
                        .isConfirmMessageDisplayed());
    }
}

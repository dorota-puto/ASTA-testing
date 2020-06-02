package ASTA.testing.tests;

import ASTA.testing.pages.DashBoardPage;
import org.testng.annotations.Test;

public class FormTest extends DefaultTest {

    @Test
    public void fillFormTest() {


        new DashBoardPage(driver).openFormPage();


    }
}

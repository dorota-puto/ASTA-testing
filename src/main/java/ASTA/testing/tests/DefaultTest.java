package ASTA.testing.tests;

import ASTA.testing.utils.BaseProperties;
import ASTA.testing.utils.CustomFile;
import ASTA.testing.utils.DriverGenerator;
import ASTA.testing.utils.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class DefaultTest {
    protected static WebDriver driver;
    protected static CustomFile customFile;


    @Parameters({"browserType", "implicitlyWait", "windowMaximize"})
    @BeforeSuite
    public void setUp(String browserType, String implicitlyWait, String windowMaximize) {
        customFile = new CustomFile();

        driver = new DriverGenerator().getDriver(
                browserType,
                Long.parseLong(implicitlyWait),
                windowMaximize.equalsIgnoreCase("true")
        );
        driver.get(BaseProperties.BASE_URL);
    }

    @AfterMethod
    public void returnHome() {
        driver.navigate().back();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

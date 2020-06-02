package ASTA.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class FormPage extends DefaultPage {

    @FindBy(className = "js-open-window")
    private WebElement applyButton;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public ApplyFormPage openApplyFormPage() {

        String parentHandle = driver.getWindowHandle();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clickElement(applyButton);

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return new ApplyFormPage(driver);
    }
}

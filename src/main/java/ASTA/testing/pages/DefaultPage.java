package ASTA.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DefaultPage {

    WebDriver driver;

    public DefaultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void wait(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void fillElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}

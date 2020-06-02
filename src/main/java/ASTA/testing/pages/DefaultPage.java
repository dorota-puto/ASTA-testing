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

    public void clickElement(WebElement element) {
        element.click();
    }
}

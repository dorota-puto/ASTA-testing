package ASTA.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class GroupPage extends DefaultPage {

    public GroupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/span/span[1]/span")
    WebElement searchField;

    public void filterItems(String filter) {

        wait(1);
        Actions builder = new Actions(driver);
        builder.moveToElement(searchField).click().perform();

        WebElement options = driver.findElement(By.cssSelector("ul.select2-results__options"));

        List<WebElement> allOptions = options.findElements(By.tagName("li"));
        for (WebElement option : allOptions) {
            if (option.getText().equals(filter)) {
                builder.moveToElement(option).click().perform();
                break;
            }
        }
    }
}

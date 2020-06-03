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

    public GroupPage filterItems(String filter) {

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
        return this;
    }

    public boolean checkIfFiltered(String filter) {

        WebElement productList = driver.findElement(By.id("product-list"));
        List<WebElement> products = productList.findElements(By.tagName("p"));

        for (int i = 2; i <= products.size(); i += 3) {
            if (!products.get(i).getText().equals(filter)) {
                return false;
            }
        }
        return true;
    }
}

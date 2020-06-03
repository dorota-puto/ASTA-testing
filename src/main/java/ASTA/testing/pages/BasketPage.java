package ASTA.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends DefaultPage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    private static double wholePrice;

    @FindBy(tagName = "form")
    static WebElement productList;


    private static void refreshWholePrice(int count, WebElement p) {
        double price = Double.parseDouble(p.findElement(By.tagName("p")).getText().split(" ")[1]);
        wholePrice += count * price;
    }

    public static WebElement filterProduct(String filter, int count) {
        List<WebElement> products = productList.findElements(By.className("caption"));

        for (WebElement p : products) {
            if (p.findElement(By.tagName("h4")).getText().equals(filter)) {
                refreshWholePrice(count, p);
                return p;
            }
        }
        return null;
    }

    public BasketPage addToBasket(int count, WebElement product) {
        WebElement countField = product.findElement(By.className("form-control"));
        wait(2);
        fillElement(countField, String.valueOf(count));

        WebElement addButton = product.findElement(By.tagName("button"));
        clickElement(addButton);
        return this;
    }

    public boolean isBasketWellCounted() {
        WebElement priceField = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div[2]/p[2]/span"));
        return Double.parseDouble(priceField.getText().split(" ")[0]) == wholePrice;
    }
}

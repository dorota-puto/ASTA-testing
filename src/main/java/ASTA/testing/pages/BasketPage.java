package ASTA.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class BasketPage extends DefaultPage {

    private BigDecimal wholePrice = new BigDecimal(0);

    @FindBy(tagName = "form")
    WebElement productList;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    private void refreshWholePrice(int count, WebElement p) {
        BigDecimal price = new BigDecimal(p.findElement(By.tagName("p")).getText().split(" ")[1]);
        BigDecimal decimalCount = new BigDecimal(count);
        wholePrice = wholePrice.add(price.multiply(decimalCount));
    }

    private WebElement filterProduct(String filter, int count) {
        List<WebElement> products = productList.findElements(By.className("caption"));

        for (WebElement p : products) {
            if (p.findElement(By.tagName("h4")).getText().equals(filter)) {
                refreshWholePrice(count, p);
                return p;
            }
        }
        return null;
    }

    public BasketPage addToBasket(Map<String, Integer> productToCount) {
        for (Map.Entry<String, Integer> pair : productToCount.entrySet()) {
            addToBasket(pair.getValue(), pair.getKey());
        }
        return this;
    }

    private BasketPage addToBasket(int count, String filter) {
        WebElement product = filterProduct(filter, count);
        WebElement countField = product.findElement(By.className("form-control"));
        wait(2);
        fillElement(countField, String.valueOf(count));

        WebElement addButton = product.findElement(By.tagName("button"));
        clickElement(addButton);
        return this;
    }

    public boolean isBasketWellCounted() {
        WebElement priceField = driver.findElement(By.className("summary-price"));
        return new BigDecimal(priceField.getText().split(" ")[0]).equals(wholePrice);
    }

    public BasketPage cleanBasket() {
        WebElement basketEl = driver.findElement(By.className("panel-body"));
        List<WebElement> delButtons = basketEl.findElements(By.tagName("button"));
        for (WebElement button : delButtons) {
            wait(1);
            clickElement(button);
        }
        return this;
    }
}

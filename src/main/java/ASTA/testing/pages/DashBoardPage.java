package ASTA.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends DefaultPage {

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Zadanie 2")
    private WebElement task2Button;

    @FindBy(linkText = "Zadanie 4")
    private WebElement task4Button;

    @FindBy(linkText = "Zadanie 1")
    private WebElement task1Button;

    public FormPage openFormPage() {
        clickElement(task4Button);
        return new FormPage(driver);
    }

    public GroupPage openGroupPage() {
        clickElement(task2Button);
        return new GroupPage(driver);
    }

    public BasketPage openBasketPage() {
        clickElement(task1Button);
        return new BasketPage(driver);
    }
}

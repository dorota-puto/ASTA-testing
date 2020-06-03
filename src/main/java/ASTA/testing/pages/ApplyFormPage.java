package ASTA.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplyFormPage extends DefaultPage {


    public ApplyFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/iframe")
    private WebElement frame;

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "phone")
    private WebElement phoneField;

    @FindBy(id = "save-btn")
    private WebElement submitButton;

    @FindBy(tagName = "h1")
    private WebElement confirmMessage;


    public ApplyFormPage fillApplyForm(String name, String email, String phone) {
        driver.switchTo().frame(frame);
        fillElement(nameField, name);
        fillElement(emailField, email);
        fillElement(phoneField, phone);
        return this;
    }

    public ApplyFormPage submitForm() {
        clickElement(submitButton);
        return this;
    }

    public boolean isConfirmMessageDisplayed() {
       return confirmMessage.isDisplayed();
    }
}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public @FindBy(id = "first-name")
    WebElement firstNameInput;
    public @FindBy(id = "last-name")
    WebElement lastNameInput;
    public @FindBy(id = "postal-code")
    WebElement postalCodeInput;
    public @FindBy(id = "continue")
    WebElement continueButton;

    public @FindBy(id = "finish")
    WebElement finishButton;

    public @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/img")
    WebElement finalPic;

    private final WebDriver driver;


    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    @Override
    public boolean isAt() {

        return continueButton.isDisplayed();
    }
}

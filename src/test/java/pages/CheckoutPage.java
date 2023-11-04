package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    private final WebDriver driver;
    public @FindBy(id = "continue")
    WebElement continueButton;


    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    @Override
    public boolean isAt() {
        return continueButton.isDisplayed();
    }
}

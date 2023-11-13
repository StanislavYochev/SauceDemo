package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addBikeLight;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addFleeceJacket;
    @FindBy(id = "backpack")
    WebElement addBackpack;
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement cartButton;
    @FindBy(id = "checkout")
    WebElement checkoutButton;
    @FindBy(xpath = "//span[@class='title']")
    WebElement pageTitle;

    @FindBy(css = "[class='shopping_cart_badge']")
    WebElement shoppingCartBadge;


    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public int getItemsInTheCart(){

        return Integer.parseInt(shoppingCartBadge.getText());
    }

    @Override
    public boolean isAt(){

        return pageTitle.isDisplayed();
    }
}

package Tests;

import base.TestUtil;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;


public class CheckoutTest extends TestUtil {

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



    @Test
    public void Checkout() {
    LoginPage loginPage = new LoginPage(driver);
    ProductPage productPage = loginPage.login("standard_user", "secret_sauce");

    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    WebElement addOnesie = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
    addOnesie.click();

    WebElement addTShirt = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
    addTShirt.click();


    WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
    cartButton.click();

    WebElement checkoutButton = driver.findElement(By.id("checkout"));
    checkoutButton.click();


    WebElement firstNameInput = driver.findElement(By.id("first-name"));
    firstNameInput.click();
    firstNameInput.clear();
    firstNameInput.sendKeys("Miroslav");

    WebElement lastNameInput = driver.findElement(By.id("last-name"));
    lastNameInput.click();
    lastNameInput.clear();
    lastNameInput.sendKeys("Miroslavov");

    WebElement postalCodeInput = driver.findElement(By.id("postal-code"));
    postalCodeInput.click();
    postalCodeInput.clear();
    postalCodeInput.sendKeys("8000");

    WebElement continueButton = driver.findElement(By.id("continue"));
    continueButton.click();

    WebElement finishButton = driver.findElement(By.id("finish"));
    finishButton.click();

    WebElement finalPic = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/img"));

    Assert.assertTrue(finalPic.isDisplayed());
}
}


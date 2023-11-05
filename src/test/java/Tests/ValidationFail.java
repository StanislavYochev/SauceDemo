package Tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class ValidationFail extends TestUtil {

    @FindBy(id = "checkout")
    WebElement checkoutButton;
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement productPage;
    @Test
    public void problemUser(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("locked_out_user", "secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Assert.assertTrue(productPage.isAt());

        WebElement addBikeLight = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addBikeLight.click();

        WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        cartButton.click();

        Assert.assertTrue(checkoutButton.isDisplayed());

    }
}

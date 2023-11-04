package Tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import java.util.concurrent.TimeUnit;

public class ProductTest extends TestUtil {
        @Test
        public void successfulAddingOfAItem(){

                LoginPage loginPage = new LoginPage(driver);
                ProductPage productPage = loginPage.login("standard_user", "secret_sauce");

                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                WebElement addBikeLight = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
                addBikeLight.click();

                WebElement addFleeceJacket = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
                addFleeceJacket.click();

                WebElement addBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
                addBackpack.click();

                WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
                cartButton.click();

                WebElement checkoutButton = driver.findElement(By.id("checkout"));
                checkoutButton.click();


                Assert.assertEquals(productPage.getItemsInTheCart(), 3, "Because we`ve just added an items");

        }
        }

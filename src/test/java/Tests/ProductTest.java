package Tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import java.util.ArrayList;

public class ProductTest extends TestUtil {
        @Test
        public void successfulAddingOfAItem(){
                LoginPage loginPage = new LoginPage(driver);
                ProductPage productPage = loginPage.login("standard_user", "secret_sauce");
                productPage.addItemToTheCart("backpack");
                productPage.addItemToTheCart("bike light");

                Assert.assertEquals(productPage.getItemsInTheCart(), 2, "Because we`ve just added an item");
        }
}
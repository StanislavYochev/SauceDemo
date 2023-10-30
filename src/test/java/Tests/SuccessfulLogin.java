package Tests;
import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class SuccessfulLogin extends TestUtil {

    @Test(dataProvider = "validUserNameFromCsv")
    public void successfulLogin1(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login(userName, password);

        Assert.assertTrue(productPage.isAt());
    }
}

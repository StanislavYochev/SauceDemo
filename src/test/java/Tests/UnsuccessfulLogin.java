package Tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class UnsuccessfulLogin extends TestUtil {
    @Test(dataProvider = "wrongUsers")
    public void unseccessfulLogin(String userName,String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);

        Assert.assertTrue(loginPage.isAt());
    }
}

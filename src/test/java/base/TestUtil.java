package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil extends DataProviders{
    public WebDriver driver;
    private String testURL, browser;
    private int implicitWait;

    @BeforeMethod
    public void setupDriverAndOpenTestAddress(){
        readConfig();
        setupDriver();
        driver.get(testURL);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    private void readConfig(){
        try{
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            testURL = properties.getProperty("URL");
            browser = properties.getProperty("browser");
            int implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
        }catch (IOException e){
            System.out.println(e);
        }
    }

    private void setupDriver(){
        switch (browser){
            case "safari":
                driver = setupSafariDriver();
                break;
            case "firefox":
                driver = setupFirefoxDriver();
                break;
            case "Edge":
                driver = setupEdgeDriver();
                break;
            default:
                driver = setupChromeDriver();
        }
    }

    private WebDriver setupFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver setupSafariDriver(){
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }

    private  WebDriver setupEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private WebDriver setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}

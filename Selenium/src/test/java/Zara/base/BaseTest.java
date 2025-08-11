package Zara.base;

import Zara.HomePage;
import Zara.ShoppingCart;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected ShoppingCart shoppingCart;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized",
                "--disable-notifications",
                "--disable-popup-blocking",
                "--disable-blink-features=AutomationControlled",
                "--no-sandbox",
                "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        homePage = new HomePage(driver);
        shoppingCart = new ShoppingCart(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}

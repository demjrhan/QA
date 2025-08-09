package KFC.base;

import Base.BasePage;
import KFC.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static Base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {
    protected BasePage basePage;
    protected HomePage homePage;
    private WebDriver driver;
    private final String baseUrl = "https://kfc.pl/";


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(baseUrl);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();

    }
    @AfterClass
    public void tearDown() {
        delay(3000);
        driver.quit();
    }
}

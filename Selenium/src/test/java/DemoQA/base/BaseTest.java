package DemoQA.base;

import Base.BasePage;
import DemoQA.pages.FormsPage;
import DemoQA.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static Base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {
    protected HomePage homePage;
    protected FormsPage formsPage;
    protected BasePage basePage;
    private WebDriver driver;
    private final String baseUrl = "https://demoqa.com/";


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

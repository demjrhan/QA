package SauceDemo.tests.products;

import SauceDemo.base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {
    private ProductsPage productsPage;
    private LoginPage loginPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testProductsHeaderDisplayed() {
        var productsPage = loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isProductsHeaderDisplayed(), "Product header is not displayed");
    }
}

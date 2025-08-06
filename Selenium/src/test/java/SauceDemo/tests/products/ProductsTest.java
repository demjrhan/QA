package SauceDemo.tests.products;

import SauceDemo.base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test
    public void testProductsHeaderDisplayed() {
        var productsPage = loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isProductsHeaderDisplayed(), "Product header is not displayed");
    }
}

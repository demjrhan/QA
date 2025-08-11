package Zara.tests;

import Zara.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    private final By item = By.xpath("//li[@data-productid='482536756']//button[@data-qa-action='product-grid-open-size-selector']");

    @Test
    public void testAddItemToShoppingCart() {

    }
}

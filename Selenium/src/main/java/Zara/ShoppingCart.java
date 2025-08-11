package Zara;

import Base.BasePageEnchanted;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart extends BasePageEnchanted {

    private final By zaraLogo = By.xpath("//a[@class='layout-header-logo__link']");

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    public ShoppingCart open() {
        driver.get("https://www.zara.com/pl/en/shop/cart");
        return this;
    }

    public HomePage goHomePage() {
        click(zaraLogo);
        return new HomePage(driver);
    }

    public ShoppingCart clickField(By locator) {
        click(locator);
        return this;
    }

    public String waitForTitleContains(String title) {
        return super.waitForTitleContains(title);
    }

}

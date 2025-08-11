package Zara;

import Base.BasePageEnchanted;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePageEnchanted {

    private final By zaraLogo = By.xpath("//a[@class='layout-header-logo__link']");
    private final By acceptCookiesButton = By.id("onetrust-accept-btn-handler");
    private final By shoppingCartId = By.xpath("//*[@id='shopCartView']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage open() {
        driver.get("https://www.zara.com/pl/en/shop/cart");
        return this;
    }

    public boolean atShoppingCartPage() {
        return isVisible(shoppingCartId);
    }

    public ShoppingCartPage acceptCookiesIfPresent() {
        if (isVisible(acceptCookiesButton)) click(acceptCookiesButton);
        return this;
    }

    public HomePage goHomePage() {
        click(zaraLogo);
        return new HomePage(driver);
    }

    public ShoppingCartPage clickField(By locator) {
        click(locator);
        return this;
    }

    public String waitForTitleContains(String title) {
        return super.waitForTitleContains(title);
    }

}

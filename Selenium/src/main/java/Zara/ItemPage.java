package Zara;

import Base.BasePageEnchanted;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePageEnchanted {

    private final By acceptCookiesButton = By.id("onetrust-accept-btn-handler");
    private final By zaraLogo = By.xpath("//a[@class='layout-header-logo__link']");
    private final By menuIcon = By.xpath("//button[@data-qa-id='layout-header-toggle-menu']");

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    /* Example item */
    public ItemPage open() {
        driver.get("https://www.zara.com/pl/en/maxi-pocket-parka-p05854810.html?v1=457464133&v2=2546081");
        return this;
    }

    public HomePage goHomePage() {
        click(menuIcon);
        click(zaraLogo);
        return new HomePage(driver);
    }
    public boolean isVisible(By locator) {
        return super.isVisible(locator);
    }

    public ItemPage acceptCookiesIfPresent() {
        if (isVisible(acceptCookiesButton)) click(acceptCookiesButton);
        return this;
    }
}

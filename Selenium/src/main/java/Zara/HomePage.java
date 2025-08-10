package Zara;

import Base.BasePageEnchanted;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageEnchanted {

    protected By acceptCookiesButton = By.id("onetrust-accept-btn-handler");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get("https://www.zara.com/pl/en/");
        return this;
    }

    public HomePage clickField(By locator) {
        click(locator);
        return this;
    }

    public HomePage typeToField(By locator, String text) {
        type(locator, text);
        return this;
    }

    public HomePage acceptCookiesIfPresent() {
        if (isVisible(acceptCookiesButton)) click(acceptCookiesButton);
        return this;
    }

}

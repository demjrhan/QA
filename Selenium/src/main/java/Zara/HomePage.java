package Zara;

import Base.BasePageEnchanted;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageEnchanted {

    private final By acceptCookiesButton = By.id("onetrust-accept-btn-handler");

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

    public void type(By locator, String text) {
        super.type(locator, text);
    }

    public HomePage acceptCookiesIfPresent() {
        if (isVisible(acceptCookiesButton)) click(acceptCookiesButton);
        return this;
    }

    public boolean isVisible(By locator) {
        return super.isVisible(locator);
    }

    public boolean isNotVisible(By locator) {
        return super.isNotVisible(locator);
    }


    public boolean isPresent(By locator) {
        return super.isPresent(locator);
    }

    public boolean isEmpty(By locator) {
        return super.isEmpty(locator);
    }

    public boolean isClickable(By locator) {
        return super.isClickable(locator);
    }
}

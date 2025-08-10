package Veeam;

import Base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {


    By cookiesButton = By.id("cookiescript_accept");
    By loginButton = By.xpath("//div[@class='header-component__container']//span[text()='Log In']");

    public HomePage() {
        driver.get("https://www.veeam.com");
        handleConsentPopup();
    }

    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginPage();
    }

    private void handleConsentPopup() {
        try {
            delay(1000);
            if (find(cookiesButton).isDisplayed()) {
                click(cookiesButton);
                System.out.println("✅ Consent popup handled successfully");
            }
        } catch (Exception e) {
            System.out.println("ℹ️ No consent popup found or already handled");
        }
    }
}

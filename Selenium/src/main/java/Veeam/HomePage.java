package Veeam;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.clickToElementJS;

public class HomePage extends BasePage {


    By cookiesButton = By.id("cookiescript_accept");
    By loginButton = By.xpath("//div[@class='header-component__container']//span[text()='Log In']");
    By bookMeetingButton = By.xpath("(//div[@class='universal-button   '])[9]");

    public HomePage() {
        driver.get("https://www.veeam.com");
        handleConsentPopup();
    }

    public LoginPage clickLoginButton() {
        find(loginButton).click();
        return new LoginPage();
    }

    public void clickBookMeetingButton() {
        delay(1000);
        click(bookMeetingButton);
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

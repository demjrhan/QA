package Veeam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginPageLoad() {

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("veeam"), "Should be on Veeam page");
        homePage.clickLoginButton();
        Assert.assertTrue(driver.getTitle().contains("Sign in") || driver.getTitle().contains("Log in"), "Should be on Login page");
    }

    @Test
    public void testSignUpPageRedirect() {
        var loginPage = homePage.clickLoginButton();
        Assert.assertTrue(driver.getTitle().contains("Sign in") || driver.getTitle().contains("Log in"), "Should be on Login page");
        loginPage.clickSignUpButton();
        Assert.assertTrue(driver.getTitle().contains("Registration") || driver.getTitle().contains("Register") || driver.getTitle().contains("Sign Up"), "Should be on Sign Up page");
    }

    @Test
    public void testResetPasswordPageRedirect() {
        var loginPage = homePage.clickLoginButton();
        Assert.assertTrue(driver.getTitle().contains("Sign in") || driver.getTitle().contains("Log in"), "Should be on Login page");
        loginPage.clickResetPasswordButton();
        Assert.assertTrue(driver.getTitle().contains("Reset") || driver.getTitle().contains("Password"), "Should be on Reset Password page");
    }

    @Test
    public void testClickingLoginButtonWithEmptyCredentials() {
        var loginPage = homePage.clickLoginButton();
        Assert.assertTrue(driver.getTitle().contains("Sign in") || driver.getTitle().contains("Log in"), "Should be on Login page");
        loginPage.clickAccountLoginButton();
        Assert.assertTrue(driver.getTitle().contains("Sign in") || driver.getTitle().contains("Log in"), "Should stay on Login page with empty credentials.");
        WebElement errorContainer = driver.findElement(By.id("error-password"));
        Assert.assertFalse(errorContainer.getText().isEmpty(), "Errors should contain both email and password errors.");
    }

}

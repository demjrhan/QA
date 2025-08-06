package SauceDemo.tests.login;

import SauceDemo.base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginErrorMessage(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauces");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        assertFalse(actualMessage.isEmpty());
    }

    @Test
    public void testUsernameCaseSensitivity(){
        loginPage.setUsername("STANDARD_USER");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        assertFalse(actualMessage.isEmpty(), "Username should be case sensitive");
    }

    @Test
    public void testPasswordCaseSensitivity(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("SECRET_SAUCE");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        assertFalse(actualMessage.isEmpty(), "Password should be case sensitive");
    }

    @Test
    public void testPasswordFieldEmpty(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        actualMessage = actualMessage.toLowerCase();
        assertTrue(actualMessage.contains("password"));
    }
    @Test
    public void testUsernameFieldEmpty(){
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        actualMessage = actualMessage.toLowerCase();
        assertTrue(actualMessage.contains("username"));
    }
    @Test
    public void testPasswordFieldIncorrect(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauces");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        actualMessage = actualMessage.toLowerCase();
        assertTrue(actualMessage.contains("password") );
    }
    @Test
    public void testUsernameFieldIncorrect(){
        loginPage.setUsername("standard_users");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        actualMessage = actualMessage.toLowerCase();
        assertTrue(actualMessage.contains("username") );
    }
}

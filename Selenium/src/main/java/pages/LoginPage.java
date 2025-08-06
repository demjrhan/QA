package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By errorMessage = By.xpath("#login_button_container h3");
    private By loginButton = By.id("login-button");

    public void setUsername(String username) {
        type(this.username,username);
    }
    public void setPassword(String password) {
        type(this.password,password);
    }
    public ProductsPage clickLoginButton() {
        click(this.loginButton);
        return new ProductsPage();
    }
    public ProductsPage login(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessage() {
        return find(this.errorMessage).getText();
    }
}

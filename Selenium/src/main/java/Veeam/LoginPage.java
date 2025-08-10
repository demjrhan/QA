package Veeam;

import Base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    By signUpRedirectButton = By.xpath("(//div[@class='content-block'])[2]//a[text()='Sign Up']");
    By resetPasswordButton = By.xpath("//div[@class='content-block']//div[@class='form-actions']//a[text()='Reset My Password']");

    public void clickSignUpButton() {
        click(signUpRedirectButton);
    }
    public void clickResetPasswordButton() {
        click(resetPasswordButton);
    }
}

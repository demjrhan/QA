package DemoQA.pages;

import Base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickToElementJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class PracticeFormPage extends BasePage {

    By maleRadioButton = By.id("gender-radio-1");
    By firstNameField = By.id("firstName");

    public void clickMaleButton(){
        scrollToElementJS(maleRadioButton);
        clickToElementJS(maleRadioButton);
    }

    public void typeFirstName(){
        scrollToElementJS(firstNameField);
        type(firstNameField, "John");
    }
}

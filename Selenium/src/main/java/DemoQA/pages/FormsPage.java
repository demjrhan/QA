package DemoQA.pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.JavaScriptUtility.clickToElementJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class FormsPage extends BasePage {

    private By practiceForm = By.xpath("//li[@id='item-0']//span[text()='Practice Form']");

    public PracticeFormPage clickPracticeForm() {
        scrollToElementJS(practiceForm);
        clickToElementJS(practiceForm);
        return new PracticeFormPage();
    }
}

package DemoQA.tests.button;

import DemoQA.base.BaseTest;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @Test
    public void testClickToElement() {
       var formsPage = homePage.goToForms().clickPracticeForm();
       formsPage.clickMaleButton();
    }
}

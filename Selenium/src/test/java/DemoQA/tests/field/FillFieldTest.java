package DemoQA.tests.field;

import DemoQA.base.BaseTest;
import org.testng.annotations.Test;

public class FillFieldTest extends BaseTest {

    @Test
    public void testFillField() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.typeFirstName();
    }

}

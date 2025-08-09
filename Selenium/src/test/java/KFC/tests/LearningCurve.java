package KFC.tests;

import KFC.base.BaseTest;
import org.testng.annotations.Test;

public class LearningCurve extends BaseTest {

    @Test
    public void typeAddress(){
        homePage.enterAcceptCookies();
        homePage.enterAddress();
        homePage.clickClosePopupButton();
        homePage.clickFirstAddressButton();
        homePage.enterFlatNumber();
    }
}

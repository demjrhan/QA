package KFC.pages;

import Base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickToElementJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class HomePage extends BasePage {

    By addressField = By.id("typeahead-address");
    By firstAddressButton = By.id("ngb-typeahead-0-0");
    By flatNumberField = By.id("flatNr");
    By acceptCookiesButton = By.id("onetrust-accept-btn-handler");
    By closePopupButton = By.xpath("//div[@class='bhr-ip__c__close ip-close-event bhr-ip__c__close--3']");

    public void enterAddress() {
        type(addressField, "Chelmska");
    }

    public void enterFlatNumber() {
        scrollToElementJS(flatNumberField);
        type(flatNumberField, "9");
    }
    public void enterAcceptCookies() {
        clickToElementJS(acceptCookiesButton);
    }
    public void clickFirstAddressButton() {
        clickToElementJS(firstAddressButton);
    }
    public void clickClosePopupButton() {
        clickToElementJS(closePopupButton);
    }
}

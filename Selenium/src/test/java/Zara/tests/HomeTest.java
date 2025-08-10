package Zara.tests;

import Zara.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    By searchField = By.xpath("//a[@data-qa-id='header-search-text-link']");
    By searchFieldInner = By.id("search-home-form-combo-input");


    @Test
    public void testClickSearchAndWrite() {
        var home = homePage.open().acceptCookiesIfPresent().clickField(searchField);
        home.clickField(searchFieldInner).typeToField(searchFieldInner, "Blazer");
    }

}

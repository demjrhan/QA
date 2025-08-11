package Zara.tests;

import Zara.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    private final By searchTrigger = By.xpath("//a[@data-qa-id='header-search-text-link']");
    private final By searchInput = By.id("search-home-form-combo-input");


    @Test
    public void testSearchTriggerIsVisibleOnLoadHomePage() {
        var home = homePage.open().acceptCookiesIfPresent();
        Assert.assertTrue(home.isVisible(searchTrigger), "Search trigger field should be visible.");
    }

    @Test
    public void testClickSearchAndWrite() {
        var home = homePage.open().acceptCookiesIfPresent().clickField(searchTrigger);
        Assert.assertTrue(home.isVisible(searchInput), "Search field should be visible.");
        home.clickField(searchInput).type(searchInput, "Blazer");
        Assert.assertFalse(home.isEmpty(searchInput), "Search field should contain text.");
    }

    @Test
    public void testSearchTriggerIsNotVisibleAfterSearchInputOpened(){
        var home = homePage.open().acceptCookiesIfPresent().clickField(searchTrigger);
        Assert.assertTrue(home.isNotVisible(searchTrigger), "Search field should be not visible after search input opened.");
    }

}

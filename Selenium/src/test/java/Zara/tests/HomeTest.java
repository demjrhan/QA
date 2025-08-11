package Zara.tests;

import Zara.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    private final By searchTrigger = By.xpath("//a[@data-qa-id='header-search-text-link']");
    private final By searchInput = By.id("search-home-form-combo-input");
    private final By searchedItemList = By.xpath("//ul[@id='search-home-form-combo-menu']");
    private final By shoppingCart = By.xpath("//a[@data-qa-id='layout-header-go-to-cart']");

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

    @Test
    public void testAfterSearchItemListPopulates() {
        var home = homePage.open().acceptCookiesIfPresent().clickField(searchTrigger);
        Assert.assertTrue(home.isVisible(searchInput), "Search field should be visible.");
        home.clickField(searchInput).type(searchInput, "Blazer");
        Assert.assertFalse(home.isEmpty(searchInput), "Search field should contain text.");
        var items = home.findAll(searchedItemList);
        Assert.assertFalse(items.isEmpty(), "Search item list should contain text.");
    }

    @Test
    public void testAfterWriteRandomTextSearchFieldItemListDoesntPopulate(){
        var home = homePage.open().acceptCookiesIfPresent().clickField(searchTrigger);
        Assert.assertTrue(home.isVisible(searchInput), "Search field should be visible.");
        home.clickField(searchInput).type(searchInput, "random-text");
        Assert.assertFalse(home.isEmpty(searchInput), "Search field should contain text.");
        Assert.assertTrue(home.isNotVisible(searchedItemList), "Search item should be not visible after bad search.");
    }

    @Test
    public void testShoppingCartShouldBeVisibleOnLoadHomePage() {
        var home = homePage.open().acceptCookiesIfPresent();
        Assert.assertTrue(home.isVisible(shoppingCart), "Shopping cart should be visible.");
    }

    @Test
    public void testShoppingCartShouldBeClickableOnLoadHomePage() {
        var home = homePage.open().acceptCookiesIfPresent();
        Assert.assertTrue(home.isClickable(shoppingCart), "Shopping cart should be clickable.");
    }

    @Test
    public void testClickingOnShoppingCartButtonBringsShoppingCartPage() {
        var cart = homePage.open().acceptCookiesIfPresent().goToShoppingCartPage();
        Assert.assertTrue(cart.atShoppingCartPage(), "Shopping cart should be opened.");

    }
    @Test
    public void testAfterOpeningShoppingCartZaraLogoShouldBringHomePage(){
        var cart = homePage.open().acceptCookiesIfPresent().goToShoppingCartPage();
        Assert.assertTrue(cart.atShoppingCartPage(), "Shopping cart should be opened.");
        var home = cart.goHomePage();
        Assert.assertTrue(home.atHomePage(), "Should open home page.");
    }


}

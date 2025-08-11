package Zara.tests;

import Zara.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemTest extends BaseTest {


    @Test
    public void testGoingBackHome() {
        var item = itemPage.open().acceptCookiesIfPresent();
        var home = item.goHomePage();
        Assert.assertTrue(home.atHomePage(), "Should open home page.");
    }
}

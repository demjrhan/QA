package Zara;

import Base.BasePageEnchanted;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageEnchanted {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get("https://www.zara.com");
        return this;
    }

}

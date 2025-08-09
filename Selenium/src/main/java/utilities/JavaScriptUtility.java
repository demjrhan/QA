package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptUtility extends Utility {


    public static void scrollToElementJS(By locator) {
        var element = driver.findElement(locator);
        String jsScript = "arguments[0].scrollIntoView()";
        ((JavascriptExecutor)driver).executeScript(jsScript, element);
    }

    public static void clickToElementJS(By locator) {
        var element = driver.findElement(locator);
        String jsScript = "arguments[0].click();";
        ((JavascriptExecutor)driver).executeScript(jsScript, element);
    }
}

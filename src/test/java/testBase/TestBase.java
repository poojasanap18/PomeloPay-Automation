package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class TestBase {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public TestBase(WebDriver driver, WebDriverWait wait) {

        TestBase.driver = driver;
    }

    protected void WaitUntilElementVisible(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
package pages;

import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void waitForVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitForVisible(locator);
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        waitForVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

    protected void delete(By locator) {
        waitForVisible(locator);
        driver.findElement(locator).clear();

    }

    protected String getText(By locator) {
        waitForVisible(locator);
        return driver.findElement(locator).getText();
    }

    protected boolean available(By locator) {
        waitForVisible(locator);
        return driver.findElement(locator).isDisplayed();
    }

    protected String getAttribute(By locator, String value) {
        waitForVisible(locator);
        return driver.findElement(locator).getAttribute(value);
    }
}

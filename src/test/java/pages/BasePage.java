package pages;

import driver.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    private By viewMenu = AppiumBy.accessibilityId("View menu");
    private By catalogMenu = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Catalog\"]");
    private By resetAppStateMenu = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Reset App State\"]");
    private By resetAppStateButton = AppiumBy.id("android:id/button1");
    private By okButton = AppiumBy.id("android:id/button1");


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

    protected List<WebElement> findElements(By locator) {
        waitForVisible(locator);
        return driver.findElements(locator);
    }

    protected WebElement scrollToElementById(String resourceId) {

        return driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\"))"
                )
        );
    }

    public void backToHome() {
        click(viewMenu);
        click(catalogMenu);
    }

    public void resetAppState() {
        click(viewMenu);
        click(resetAppStateMenu);
        click(resetAppStateButton);
        click(okButton);
    }
}

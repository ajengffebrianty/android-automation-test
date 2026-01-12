package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {
    public CheckoutPage() {}

    private By title = AppiumBy.id("com.saucelabs.mydemoapp.android:id/checkoutTitleTV");

    public String getTitlePage() {
        return getText(title);
    }
}

package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FingerprintPage extends BasePage {
    public FingerprintPage() {}

    private By viewMenu = AppiumBy.accessibilityId("View menu");
    private By fingerPrintMenu = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"FingerPrint\"]");
    private By allowFingerPrintToggle = AppiumBy.accessibilityId("Enable or disable biometric login");


    public void goToFingerPrintMenu() {
        click(viewMenu);
        click(fingerPrintMenu);
    }

    public void clickAllowFingerPrintToggle() {
        String toggleAttribute = getAttribute(allowFingerPrintToggle, "checked");
        if (!toggleAttribute.equals("true")) {
            click(allowFingerPrintToggle);
        }
    }
}

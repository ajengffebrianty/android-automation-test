package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage() {
    }

    private By viewMenu = AppiumBy.accessibilityId("View menu");
    private By loginMenu = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Log In\"]\n");
    private By usernameText = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    private By passwordText = AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private By passwordRequiredErr = AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordErrorTV");
    private By loginButton = AppiumBy.accessibilityId("Tap to login with given credentials");
    private By usernameRequiredErr = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameErrorTV");
    private By fingerPrintButton = AppiumBy.accessibilityId("Tap to login using biometric verification");
    private By validLoginButton = AppiumBy.id("com.saucelabs.mydemoapp.android:id/username1TV");

    public void goToLoginMenu() {
        click(viewMenu);
        click(loginMenu);
    }

    public void enterUsername(String username) {
        type(usernameText, username);
    }

    public void deleteUsernameField() {
        delete(usernameText);
    }

    public void enterPassword(String password) {
        type(passwordText, password);
    }

    public void tapLogin() {
        click(loginButton);
    }

    public void populateValidLogin() {
        click(validLoginButton);
    }
    public String getPasswordRequiredErr() {
        return getText(passwordRequiredErr);
    }

    public String getUsernameRequiredErr() {
        return getText(usernameRequiredErr);
    }

    public boolean fingerPrintButtonAvailable() {
        return available(fingerPrintButton);
    }
}

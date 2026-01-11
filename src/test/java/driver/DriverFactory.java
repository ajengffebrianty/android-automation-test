package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static AndroidDriver driver;

    public static void initDriver() throws Exception {
        String appiumServerUrl = System.getProperty("appium.server.url", "http://127.0.0.1:4723");
        String appPath = System.getProperty("user.dir") + File.separator + "apps" + File.separator + "mda-1.0.13-15.apk";
        File appFile = new File(appPath);
        
        if (!appFile.exists()) {
            throw new RuntimeException("App file not found at: " + appPath);
        }

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setApp(appFile.getAbsolutePath())
                .setAppPackage("com.saucelabs.mydemoapp.android")
                .setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity")
                .setNoReset(true)
                .setNewCommandTimeout(Duration.ofSeconds(300))
                .setFullReset(false)
                .setUiautomator2ServerInstallTimeout(Duration.ofSeconds(300))
                .setSkipServerInstallation(false)
                .setSkipUnlock(true);

        String deviceName = System.getProperty("device.name", "Android Device");
        String udid = System.getProperty("device.udid");
        
        options.setDeviceName(deviceName);
        if (udid != null && !udid.isEmpty()) {
            options.setUdid(udid);
        }

        driver = new AndroidDriver(
                new URL(appiumServerUrl),
                options
        );
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver has not been initialized. Call initDriver() first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Driver closed successfully");
            } catch (Exception e) {
                System.err.println("Error closing driver: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }
}

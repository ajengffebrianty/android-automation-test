package stepdefinitions;

import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;

public class CommonSteps {
    private AndroidDriver driver;
    @Given("the app is launched")
    public void the_app_is_launched() {
        driver = DriverFactory.getDriver();
    }
}

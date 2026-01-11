package stepdefinitions;

import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.FingerprintPage;
import pages.LoginPage;
import pages.ProductPage;

public class LoginSteps {

    private AndroidDriver driver;
    private final LoginPage page = new LoginPage();
    private final ProductPage productPage = new ProductPage();
    private final FingerprintPage fingerprintPage = new FingerprintPage();

    @Given("I'm on login screen")
    public void i_on_login_screen() {
        driver = DriverFactory.getDriver();
        page.goToLoginMenu();
    }

    @When("I navigate to login screen")
    public void i_navigate_to_login_screen() {
        page.goToLoginMenu();
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        page.enterUsername(username);
        page.enterPassword(password);
    }

    @When("I clear the username")
    public void i_clear_the_username() {
        page.deleteUsernameField();
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        page.enterPassword(password);
    }

    @When("I tap the login button")
    public void i_tap_the_login_button() {
        page.tapLogin();
    }

    @Then("I should see error message under username field {string}")
    public void error_message_under_username(String expectedMessage) {
        String shownMessage = page.getUsernameRequiredErr();
        Assert.assertEquals(shownMessage, expectedMessage, "Error message does not match!");
    }

    @Then("I should see error message under password field {string}")
    public void error_message_under_password(String expectedMessage) {
        String shownMessage = page.getPasswordRequiredErr();
        Assert.assertEquals(shownMessage, expectedMessage, "Error message does not match!");
    }

    @Then("I should redirect to Products page")
    public void i_should_redirect_to_products_page() {
        String getTitlePage = productPage.getTitlePage();
        Assert.assertEquals(getTitlePage, "Products", "Title page does not match!");
    }

    @Then("I navigate to Fingerprint page")
    public void i_navigate_to_Fingerprint_page() {
        fingerprintPage.goToFingerPrintMenu();
    }

    @When("I enable to login with Fingerprint")
    public void i_enable_to_login_with_fingerprint() {
        fingerprintPage.clickAllowFingerPrintToggle();
    }

    @Then("I should see fingerprint button")
    public void i_should_see_fingerprint_button() {
        Assert.assertTrue(page.fingerPrintButtonAvailable());
    }
}

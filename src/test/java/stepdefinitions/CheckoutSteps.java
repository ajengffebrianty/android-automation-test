package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class CheckoutSteps {
    private static final Logger log = LoggerFactory.getLogger(CheckoutSteps.class);
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    LoginPage loginPage = new LoginPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    @Given("user on cart page")
    public void user_on_cart_page() {
        productPage.tapFirstProduct();
        productPage.addProductToCart();
        cartPage.tapCartIcon();
    }

    @When("Press \"Proceed to Checkout\" button")
    public void press_proceed_button() {
        cartPage.tapCheckout();
    }
    @When ("Login with valid username and password")
    public void login_with_valid_username_and_password() {
        loginPage.populateValidLogin();
        loginPage.tapLogin();
    }
    @Then("Page will redirect to checkout page to fill shipping address")
    public void page_will_redirect_to_checkout_page() {
        Assert.assertEquals(checkoutPage.getTitlePage(), "Checkout");

    }
}

package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductPage;

import java.time.Duration;
import java.util.List;

public class CartSteps {
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    String productName;
    Integer productQuantity;

    @Given("user in product detail page")
    public void user_in_product_detail_page() {
        productPage.tapFirstProduct();
        productName = productPage.getTitlePage();
    }

    @Given("user in product page")
    public void user_in_product_page() {
        String getTitlePage = productPage.getTitlePage();
        Assert.assertEquals(getTitlePage, "Products", "Title page does not match!");
    }

    @When("Reset app state")
    public void reset_app_state() {
        cartPage.resetAppState();
    }

    @When("Press cart icon on right side")
    public void press_cart_icon_on_right_side() {
        cartPage.tapCartIcon();
    }

    @Then("Page will redirect to carts page")
    public void page_will_redirect_to_carts_page() {
        Assert.assertTrue(cartPage.verifyCartPageDisplayed());
    }

    @Then("No items title and Go shopping button will show if cart is empty")
    public void no_items_title_and_go_shopping_button_will_show_if_cart_is_empty() {
        Assert.assertTrue(cartPage.verifyEmptyCart());
    }

    @Then("List of product and proceed to checkout button will show if cart is not empty")
    public void list_of_product_and_proceed_to_checkout_button_will_show_if_cart_is_not_empty() {
        cartPage.tapGoShoppingButton();
        productPage.tapFirstProduct();
        productPage.addProductToCart();
        cartPage.tapCartIcon();
        Assert.assertTrue(cartPage.verifyCartWithItems());
    }

    @When("user press add to cart button")
    public void user_press_add_to_cart_button() {
        productPage.addProductToCart();
    }

    @Then("verify the product has been added")
    public void verify_the_product_has_been_added() {
        List<String> productCartName = cartPage.getProductName();
        Assert.assertTrue(productCartName.contains(productName));
    }

    @When("user sets the product quantity to more than one")
    public void user_sets_the_product_quantity_to_more_than_one() {
        productPage.addQuantity();
    }

    @Then("the cart should contain the product with the selected quantity")
    public void the_cart_should_contain_the_product_with_the_selected_quantity() {
        productQuantity = productPage.getQuantityCount();
        cartPage.tapCartIcon();
        int totalItems = cartPage.getTotalItems();
        Assert.assertEquals(totalItems, productQuantity);
    }

    @When("user adds the first product to the cart")
    public void user_adds_the_first_product_to_the_cart() {
        productPage.tapFirstProduct();
        productPage.addProductToCart();
    }

    @When("user adds another product to the cart")
    public void user_adds_another_product_to_the_cart() {
        cartPage.goToCatalog();
        productPage.tapSecondProduct();
        productPage.addProductToCart();
    }

    @Then("the cart should contain more than one product")
    public void the_cart_should_contain_more_than_one_product() {
        cartPage.tapCartIcon();
        Assert.assertTrue(cartPage.countProductname() > 1);
    }

    @Given("user has added multiple products to the cart")
    public void the_user_has_added_multiple_products_to_the_cart() {
        productPage.tapFirstProduct();
        productPage.addProductToCart();
        cartPage.goToCatalog();
        productPage.tapSecondProduct();
        productPage.addProductToCart();

    }

    @Given("user is on the cart page")
    public void the_user_is_on_the_cart_page() {
        cartPage.tapCartIcon();
    }

    @When("user check counter functionality in cart page")
    public void the_user_increases_the_quantity_of_the_first_product() {
        Assert.assertTrue(cartPage.counterIsClickable());
    }

    @When("quantity will increased or decreased in cart page")
    public void the_user_decreases_the_quantity_of_the_first_product_to_one() {
        Assert.assertTrue(cartPage.counterIsValid());
    }

/* =========================
   Remove item
========================= */

    @When("user taps the \"Remove Item\" button on a product")
    public void the_user_taps_the_remove_item_button_on_a_product() {
        productQuantity =  cartPage.countProductname();
         cartPage.tapRemoveItem();
    }

    @Then("the selected product should be removed from the cart")
    public void the_selected_product_should_be_removed_from_the_cart() {
        Assert.assertTrue(cartPage.countProductname() < productQuantity);
    }

    @When("user taps the \"Proceed to Checkout\" button")
    public void the_user_taps_the_proceed_to_checkout_button() {
        cartPage.tapCheckout();
    }

    @Then("user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_checkout_page() {
         cartPage.loginPageDisplayed();
    }


}

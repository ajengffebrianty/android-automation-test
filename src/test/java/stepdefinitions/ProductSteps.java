package stepdefinitions;

import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductSteps {
    private AndroidDriver driver;
    private final ProductPage productPage = new ProductPage();

    @Then("the product list should be displayed")
    public void the_product_list_should_be_displayed() {
        Assert.assertTrue(productPage.countProductName() > 1, "Expected more than 1 product name, but found " + productPage.countProductName()
        );
    }

    @Then("the product images should be displayed")
    public void the_product_image_should_be_displayed() {
        Assert.assertTrue(productPage.countProductImage() > 1, "Expected more than 1 product image, but found " + productPage.countProductImage()
        );
    }

    @Then("the product prices should be displayed")
    public void the_product_price_should_be_displayed() {
        Assert.assertTrue(productPage.countProductPrice() > 1, "Expected more than 1 product image, but found " + productPage.countProductPrice()
        );
    }

    @When("sort button clicked")
    public void sort_button_clicked() {
        productPage.tapSort();
    }

    @Then("sort by-name-ascending will selected as default")
    public void sort_by_name_ascending_will_selected_as_default() {
        Assert.assertTrue(productPage.sortIsSelected());
        productPage.tapNameAscSort();
    }

    @Then("product name should be show in ascending order")
    public void product_name_should_be_show_in_ascending_order() {
        List<String> actualNames = productPage.getProductNamesList();

        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames);

        Assert.assertEquals(
                actualNames,
                expectedNames,
                "Product names are not sorted in ascending order"
        );
    }

    @When("product sort by-name-descending selected")
    public void sort_by_name_descending_selected() {
        productPage.tapSort();
        productPage.tapNameDescSort();
    }

    @Then("product name should be show in descending order")
    public void product_name_should_be_show_in_descending_order() {
        List<String> actualNames = productPage.getProductNamesList();
        List<String> expectedNames = new ArrayList<>(actualNames);
        expectedNames.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        Assert.assertEquals(
                actualNames,
                expectedNames,
                "Product names are not sorted in descending order"
        );
    }

    @When("product sort by-price-ascending selected")
    public void sort_by_price_ascending_selected() {
        productPage.tapSort();
        productPage.tapPriceAscSort();
    }

    @Then("product price should be show in ascending order")
    public void product_price_should_be_show_in_ascending_order() {
        List<Double> actualPrice = productPage.getProductPricesList();
        List<Double> expectedPrice = new ArrayList<>(actualPrice);
        Collections.sort(expectedPrice);

        Assert.assertEquals(
                actualPrice,
                expectedPrice,
                "Product names are not sorted in ascending order"
        );
    }

    @When("product sort by-price-descending selected")
    public void sort_by_price_descending_selected() {
        productPage.tapSort();
        productPage.tapPriceDescSort();
    }

    @Then("product price should be show in descending order")
    public void product_price_should_be_show_in_descending_order() {
        List<Double> actualPrice = productPage.getProductPricesList();
        List<Double> expectedPrice = new ArrayList<>(actualPrice);
        expectedPrice.sort(Collections.reverseOrder());

        Assert.assertEquals(
                actualPrice,
                expectedPrice,
                "Product names are not sorted in descending order"
        );
    }

    @When("Select one of product")
    public void select_one_of_product() {
        productPage.tapFirstProduct();
    }

    @Then("page should be show the product detail")
    public void then_page_should_be_show_the_product_detail() {
        productPage.productDetailElementAvailable();
    }

    @When ("Check if color button can be clicked")
    public void the_user_selects_another_color_of_the_product() {
        Assert.assertTrue(productPage.colorIsClickable());
    }

    @When("user check counter functionality")
    public void the_user_increases_the_product_quantity() {
       Assert.assertTrue(productPage.counterIsClickable());
    }

    @Then("quantity increased or decreased")
    public void quantity_increased_or_decreased() {
        Assert.assertTrue(productPage.counterIsValid());
    }

    @When("user presses the Add to cart button")
    public void the_user_presses_the_Add_to_cart_button() {
        productPage.addToCartClick();
    }

    @Then ("Cart number changed")
    public void cart_number_changed() {
        Assert.assertTrue(productPage.cartNumberIsValid());
    }

    @Then("user presses the Add to cart button again")
    public void the_user_presses_the_Add_to_cart_button_again() {
        productPage.addToCartClick();
    }



}

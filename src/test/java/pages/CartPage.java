package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    public CartPage() {
    }

    private String productName;
    private By cartElement = AppiumBy.accessibilityId("View cart");
    private By cartEmptyPage = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartInfoLL");
    private By cartNotEmptyPage = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartCL");
    private By noItemsTitle = AppiumBy.id("com.saucelabs.mydemoapp.android:id/noItemTitleTV");
    private By goShoppingButton = AppiumBy.id("com.saucelabs.mydemoapp.android:id/shoppingBt");
    private By listProductElement = AppiumBy.accessibilityId("Displays list of selected products");
    private By proceedToCheckooutButton = AppiumBy.accessibilityId("Confirms products for checkout");
    private By productNameText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]");
    private By totalText = AppiumBy.id("com.saucelabs.mydemoapp.android:id/itemsTV");
    private By viewMenu = AppiumBy.accessibilityId("View menu");
    private By catalogMenu = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Catalog\"]");
    private By decreaseQuantityFirstElement = AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Decrease item quantity\"])[1]");
    private By increaseQuantityFirstElement = AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Increase item quantity\"])[1]");
    private By quantityFirstElement = AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"])[1]");
    private By removeItemButton = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"Removes product from cart\"])[1]");
    private By checkoutButton = AppiumBy.accessibilityId("Confirms products for checkout");
    private By loginTitle = AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginTV");

    public void tapCartIcon() {
        click(cartElement);
    }

    public void tapGoShoppingButton() {
        click(goShoppingButton);
    }

    public boolean verifyCartPageDisplayed() {
        return available(cartEmptyPage) || available(cartNotEmptyPage);
    }

    public boolean verifyEmptyCart() {
        return available(noItemsTitle) && available(goShoppingButton);
    }

    public boolean verifyCartWithItems() {
        return available(listProductElement) && available(proceedToCheckooutButton);
    }

    public List<String> getProductName() {
        List<WebElement> elements = findElements(productNameText);
        List<String> names = new ArrayList<>();

        for (WebElement el : elements) {
            names.add(el.getText());
        }
        return names;
    }

    public int countProductname() {
        List<WebElement> productNames = findElements(productNameText);
        return productNames.size();
    }

    public int getTotalItems() {
        int number = Integer.parseInt(getText(totalText).replaceAll("\\D+", ""));
        return number;
    }

    public void goToCatalog() {
        click(viewMenu);
        click(catalogMenu);
    }

    public void addQtyFirstProduct() {
        click(increaseQuantityFirstElement);
    }

    public boolean counterIsValid() {
        scrollToElementById("com.saucelabs.mydemoapp.android:id/noTV");
        Integer quantityBefore = Integer.parseInt(getText(quantityFirstElement));
        click(increaseQuantityFirstElement);
        Integer afterIncrease = Integer.parseInt(getText(quantityFirstElement));
        boolean incResult = afterIncrease > quantityBefore;
        click(decreaseQuantityFirstElement);
        Integer afterDecrease = Integer.parseInt(getText(quantityFirstElement));
        boolean decResult = afterDecrease < afterIncrease;

        return incResult && decResult;
    }

    public boolean counterIsClickable() {
        boolean canIncrease = "true".equals(getAttribute(increaseQuantityFirstElement, "clickable"));
        boolean canDecrease = "true".equals(getAttribute(decreaseQuantityFirstElement, "clickable"));

        return canIncrease && canDecrease;
    }

    public void tapRemoveItem() {
        click(removeItemButton);
    }

    public void tapCheckout() {
        click(checkoutButton);
    }

    public void loginPageDisplayed() {
        available(loginTitle);
    }

}

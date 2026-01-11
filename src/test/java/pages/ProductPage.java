package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage() {
    }

    private By titlePage = AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV");
    private By listNameProduct = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"]");
    private By listImageProduct = AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productIV\"]");
    private By listPriceProduct = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/priceTV\"]");
    private By sortButton = AppiumBy.accessibilityId("Shows current sorting order and displays available sorting options");
    private By nameAscSelected = AppiumBy.xpath(
            "//android.view.ViewGroup[@resource-id='com.saucelabs.mydemoapp.android:id/nameAscCL']" +
                    "//android.widget.ImageView[@resource-id='com.saucelabs.mydemoapp.android:id/tickNameAscIV']"
    );
    private By nameAscSortButton = AppiumBy.accessibilityId("Ascending order by name");
    private By nameDescSortButton = AppiumBy.accessibilityId("Descending order by name");
    private By priceAscSortButton = AppiumBy.accessibilityId("Ascending order by price");
    private By priceDescSortButton = AppiumBy.accessibilityId("Descending order by price");
    private By firstProductElement = AppiumBy.xpath("(//android.widget.ImageView[@resource-id='com.saucelabs.mydemoapp.android:id/productIV'])[1]");
    private By cartElement = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartTV");
    private By productDetailImageElement = AppiumBy.accessibilityId("Displays selected product");
    private By productDetailPriceElement = AppiumBy.id("com.saucelabs.mydemoapp.android:id/priceTV");
    private By productDetailColorElement = AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays available colors of selected product\"]/android.view.ViewGroup");
    private By decreaseQuantityElement = AppiumBy.accessibilityId("Decrease item quantity");
    private By increaseQuantityElement = AppiumBy.accessibilityId("Increase item quantity");
    private By productDetailQuantityElement = AppiumBy.id("com.saucelabs.mydemoapp.android:id/noTV");
    private By productDetailAddCartButton = AppiumBy.accessibilityId("Tap to add product to cart");


    public String getTitlePage() {
        return getText(titlePage);
    }

    public Integer countProductName() {
        List<WebElement> productNames = findElements(listNameProduct);
        return productNames.size();
    }

    public List<String> getProductNamesList() {
        List<WebElement> elements = findElements(listNameProduct);
        List<String> names = new ArrayList<>();

        for (WebElement el : elements) {
            names.add(el.getText());
        }
        return names;
    }

    public Integer countProductImage() {
        List<WebElement> productImages = findElements(listImageProduct);
        return productImages.size();
    }

    public Integer countProductPrice() {
        List<WebElement> productImages = findElements(listPriceProduct);
        return productImages.size();
    }

    public List<Double> getProductPricesList() {
        List<WebElement> elements = findElements(listPriceProduct);
        List<Double> prices = new ArrayList<>();
        for (WebElement el : elements) {
            String text = el.getText();     // "$ 7.99"
            text = text.replace("$", "").trim(); // "7.99"
            prices.add(Double.parseDouble(text));
        }

        return prices;
    }

    public void tapSort() {
        click(sortButton);
    }

    public void tapNameAscSort() {
        click(nameAscSortButton);
    }

    public void tapPriceAscSort() {
        click(priceAscSortButton);
    }

    public void tapNameDescSort() {
        click(nameDescSortButton);
    }

    public void tapPriceDescSort() {
        click(priceDescSortButton);
    }

    public boolean sortIsSelected() {
        return available(nameAscSelected);
    }

    public void tapFirstProduct() {
        click(firstProductElement);
    }

    public boolean productDetailElementAvailable() {
        boolean element = available(productDetailImageElement) && available(productDetailPriceElement) && available(productDetailColorElement) && available(productDetailAddCartButton);
        return element;
    }

    public boolean colorIsClickable() {
        if (getAttribute(productDetailColorElement, "clickable").equals("true")) {
            return true;
        }
        return false;
    }

    public boolean counterIsClickable() {
        scrollToElementById("com.saucelabs.mydemoapp.android:id/noTV");
        boolean canIncrease = "true".equals(getAttribute(increaseQuantityElement, "clickable"));

        boolean canDecrease = "true".equals(getAttribute(decreaseQuantityElement, "clickable"));

        return canIncrease && canDecrease;
    }

    public boolean counterIsValid() {
        scrollToElementById("com.saucelabs.mydemoapp.android:id/noTV");
        Integer quantityBefore = Integer.parseInt(getText(productDetailQuantityElement));
        click(increaseQuantityElement);
        Integer afterIncrease = Integer.parseInt(getText(productDetailQuantityElement));
        boolean incResult = afterIncrease > quantityBefore;
        click(decreaseQuantityElement);
        Integer afterDecrease = Integer.parseInt(getText(productDetailQuantityElement));
        boolean decResult = afterDecrease < afterIncrease;

        return incResult && decResult;
    }

    public void addToCartClick () {
        click(productDetailAddCartButton);
    }

    private int getCartCount(By cartElement) {

        List<WebElement> elements = driver.findElements(cartElement);

        if (elements.isEmpty()) {
            return 0;
        }

        String textAttr = elements.get(0).getAttribute("text");

        if (textAttr == null || textAttr.trim().isEmpty()) {
            return 0;
        }

        return Integer.parseInt(textAttr.trim());
    }

    public boolean cartNumberIsValid() {
        int countBefore = getCartCount(cartElement);

        click(productDetailAddCartButton);

        int countAfter = getCartCount(cartElement);
        boolean cart = countAfter == countBefore + 1;

        return cart;
    }


}

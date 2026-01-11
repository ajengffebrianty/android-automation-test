package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    public ProductPage() {}

    private By titlePage = AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV");
    private By listImageProduct = AppiumBy.className("android.widget.ImageView");;

    public String getTitlePage() {
        return getText(titlePage);
    }

}

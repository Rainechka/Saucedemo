package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private static final By INVENTORY_ITEM = By.cssSelector(".inventory_item_name ");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getProductsName() {
        List<WebElement> allProductsNames = driver.findElements(INVENTORY_ITEM);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }
}

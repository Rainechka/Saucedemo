package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final By title = By.cssSelector("[class='title']");
    private final By title2 = By.xpath("//*[text()='Products']");
    private static final String ADD_TO_CART_BUTTON_PATTERN
            = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public  boolean titleIsDisplayed() {
        return driver.findElement(title2).isDisplayed();
    }

    public void addToCart(String goodsName) throws InterruptedException {
        By addToCard = By.xpath(String.format(ADD_TO_CART_BUTTON_PATTERN));
        Thread.sleep(8000);
        driver.findElement(addToCard).click();

    }
}

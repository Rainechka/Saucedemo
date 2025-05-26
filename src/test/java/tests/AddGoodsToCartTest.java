package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class AddGoodsToCartTest extends BaseTest {
    @Epic("Модуль логина интернет-магазина")
    @Feature("Юридические лица")
    @Story("STG")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Noskova E. V. rainechka@gmail.com")
    @TmsLink("Rainechka")
    @Issue("2")
    @Test(description = "проверяем, что товары добавлены в корзину")
    @Flaky
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        productsPage.isOpen();
        productsPage.addToCart(0);
        productsPage.addToCart(2);
        productsPage.addToCart(3);
        productsPage.openCart();
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsName().size(), 3);
        assertFalse(cartPage.getProductsName().isEmpty());
    }
}

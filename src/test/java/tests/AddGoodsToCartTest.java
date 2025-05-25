package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class AddGoodsToCartTest extends BaseTest {
    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(user, password);
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
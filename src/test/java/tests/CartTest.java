package tests;

import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.Assert.assertEquals;

public class CartTest extends tests.BaseTest{

    @Test
    public void addToCart () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.clickToCart();
        assertEquals(productsPage.getTitle(),
                "Your Cart",
                "корзина не открылась!");
    }

    @Test
    public void remove() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.clickToCart();
        cartPage.removeProduct();
    }
}

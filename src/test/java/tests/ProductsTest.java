package tests;

import org.testng.annotations.Test;

public class ProductsTest extends tests.BaseTest{

    @Test
    public void cartOpen() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickToCart();
    }

    @Test
    public void addToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
    }
}

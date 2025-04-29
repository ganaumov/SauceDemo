package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckOutTest extends tests.BaseTest{

    @Test
    public void negativeSendKeys(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.clickToCart();
        cartPage.goCheckOut();
        checkOutPage.clickContinue();
        assertEquals(checkOutPage.errorMessage(),
                "Error: First Name is required",
                "ошибка не появилась");
    }

    @Test
    public void positiveSendKeys() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.clickToCart();
        cartPage.goCheckOut();
        checkOutPage.sendKeys("Dmitriy", "Gala", "12345");
        checkOutPage.clickContinue();
        assertEquals(checkOutPage.getTitle(),
                "Checkout: Overview",
                "переход на checkout не совершен!");
        checkOutPage.finishCheckOut();
        assertEquals(checkOutPage.getTitle(),
                "Checkout: Complete!",
                "finish не совершен!");
    }
}

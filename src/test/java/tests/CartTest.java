package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.Assert.assertEquals;

public class CartTest extends tests.BaseTest{

    @Description("Проверка добавления товара в корзину")
    @Test(testName = "добавление в корзину",
    description = "проверка добавления товара в корзину")
    public void addToCart () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.clickToCart();
        assertEquals(productsPage.getTitle(),
                "Your Cart",
                "корзина не открылась!");
    }

    @Description("Проверка функции удаления товара из корзины")
    @Test(testName = "удаление товара из корзины",
    description = "проверка функции удаления товара из корзины")
    public void checkRemoveProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.clickToCart();
        cartPage.removeProduct();
        //не знаю как проверить
    }
}

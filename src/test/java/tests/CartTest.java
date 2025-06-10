package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CartTest extends tests.BaseTest{

    @Description("Проверка добавления товара в корзину")
    @Test(testName = "добавление в корзину",
    description = "проверка добавления товара в корзину")
    public void addToCart () {
        log.info("Add to cart test");
        loginPage.open();
        loginPage.login(user, password);
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
        log.info("Delete from cart test");
        loginPage.open();
        loginPage.login(user, password);
        productsPage.addToCart();
        productsPage.clickToCart();
        cartPage.removeProduct();
        //не знаю как проверить
    }
}

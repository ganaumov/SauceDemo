package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends tests.BaseTest{

    @Description("Проверка перехода на страницу корзины")
    @Test(testName = "открытие корзины",
    description = "проверка кликабельного перехода на страницу корзины")
    public void cartOpen() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickToCart();
        String text = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(text,
                "Your Cart",
                "Текст не найден");
    }

    @Description("Проверка добавления товара в корзину")
    @Test(testName = "добавление в корзину",
    description = "проверка добавления товара в корзину")
    public void addToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        String text = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span")).getText();
        Assert.assertEquals(text,
                "1",
                "Не добавлено в корзину");
    }
}

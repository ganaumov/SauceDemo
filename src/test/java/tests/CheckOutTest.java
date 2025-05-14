package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckOutTest extends tests.BaseTest{

    @Description("Оформления заказа без заполнения всех данных")
    @Test(testName = "проверка оформления заказа без данных",
    description = "попытка оформления заказа без заполнения всех данных")
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

    @Description("Проверка оформления заказа с заполнением всех обязательных полей")
    @Test(testName = "проверка оформления заказа",
    description = "проверка стандартного оформления заказа с заполнением всех обязательных дынных")
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
                "Завершение не произошло!");
    }
}

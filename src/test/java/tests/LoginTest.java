package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends tests.BaseTest {

    @Epic("Заполнение полей логина")
    @Feature("Форма логина")
    @Story("Пустой логин")
    @Description("Првоерка логина с пустым паролем")
    @Severity(SeverityLevel.MINOR)
    @Owner("Vladimir Naumov")
    @TmsLink("SD-01")
    @Issue("SD-BUG-01")
    @Link(name = "Документация", url = "https://www.saucedemo.com/")
    @Flaky
    @Test(testName = "Проверка логина в систему (пустой пароль)",
            description = "проверяем вход систему с пустым паролем")
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Password is required",
                "ошибка не появилась");
    }

    @Description("Проверяем вход систему с неверным паролем")
    @Test(testName = "Проверка логина в систему (неверный пароль)",
            description = "проверяем вход систему с неверным паролем")
    public void checkLoginWithWrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "12345678");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "ошибка не появилась");
    }

    @Description("Проверяем вход систему с пустым полем username")
    @Test(testName = "Проверка логина в систему (пустой логин)",
            description = "проверяем вход систему с пустым полем username")
    public void checkLoginWithEmptyUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Usernam is required",
                "ошибка не появилась");
    }

    @Description("Проверяем вход систему с верными данными для входа")
    @Test(testName = "Проверка входа в систему с верными данными",
            description = "проверяем вход систему с верными данными для входа")
    public void checkPositiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "ошибки нету");
    }

}

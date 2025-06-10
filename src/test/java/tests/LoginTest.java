package tests;
//
import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
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
        log.info("Log in without password");
        loginPage.open();
        loginPage.login(user, "");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Password is required",
                "ошибка не появилась");
    }

    @Description("Проверяем вход систему с неверным паролем")
    @Test(testName = "Проверка логина в систему (неверный пароль)",
            description = "проверяем вход систему с неверным паролем")
    public void checkLoginWithWrongPassword() {
        log.info("Log in with wrong password");
        loginPage.open();
        loginPage.login(user, "12345678");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "ошибка не появилась");
    }

    @Description("Проверяем вход систему с пустым полем username")
    @Test(testName = "Проверка логина в систему (пустой логин)",
            description = "проверяем вход систему с пустым полем username")
    public void checkLoginWithEmptyUsername() {
        log.info("Log in without username");
        loginPage.open();
        loginPage.login("", password);
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "ошибка не появилась");
    }

    @Description("Проверяем вход систему с верными данными для входа")
    @Test(testName = "Проверка входа в систему с верными данными",
            description = "проверяем вход систему с верными данными для входа")
    public void checkPositiveLogin() {
        log.info("Log in positive");
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(productsPage.getTitle(),
                "Products",
                "ошибки нету");
    }

}

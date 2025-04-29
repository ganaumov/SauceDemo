package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends tests.BaseTest {

    @Test
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Password is required",
                "ошибка не появилась");
    }

    public void checkLoginWithWrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "12345678");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "ошибка не появилась");
    }

    public void checkLoginWithEmptyUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "ошибка не появилась");
    }

    public void checkPositiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "ошибки нету");
    }
}

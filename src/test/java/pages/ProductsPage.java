package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private static final By SORT = By.className("product_sort_container");
    private static final By SORT_LH = By.cssSelector("#header_container > div.header_secondary_container" +
            " > div > span > select > option:nth-child(3)");
    private static final By ADD_TO_CART = By.name("add-to-cart-sauce-labs-bike-light");
    private static final By REMOVE = By.xpath("//*[@data-test='remove-sauce-labs-backpack']");
    private static final By CART = By.xpath("//*[@data-test='shopping-cart-link']");

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void sortLh() {
        driver.findElement(SORT).click();
        driver.findElement(SORT_LH).click();
    }

    @Step("Добавление товара в корзину")
    public void addToCart() {
        driver.findElement(ADD_TO_CART).click();
    }

    @Step("Удаление товара из корзины")
    public void removeProduct() {
        driver.findElement(REMOVE).click();
    }

    @Step("Нажатие на кнопку корзина в ui")
    public void clickToCart() {
        driver.findElement(CART).click();
    }
}

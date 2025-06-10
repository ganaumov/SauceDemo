package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final By CONTINUE_SHOPPING = By.id("continue-shopping");
    private static final By CHECKOUT = By.id("checkout");
    private static final By BURGER_MENU = By.id("react-burger-menu-btn");
    private static final By CART_NAME = By.xpath("//*[@data-test='title']");
    private static final By PRODUCT_IN_CART = By.cssSelector("[data-test='inventory-item-name']");
    private static final By REMOVE_PRODUCT = By.id("remove-sauce-labs-bike-light");

    public String getCartTitle() {
        return driver.findElement(CART_NAME).getText();
    }

    public void continueShopping(){
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    public void goCheckOut(){
        driver.findElement(CHECKOUT).click();
    }

    public void clickBurger(){
        driver.findElement(BURGER_MENU).click();
    }

    public void checkProduct(){
        driver.findElement(PRODUCT_IN_CART).isDisplayed();
    }

    public void removeProduct(){
        driver.findElement(REMOVE_PRODUCT).click();
    }
}

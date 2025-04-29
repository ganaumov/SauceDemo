package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_CODE = By.id("postal-code");
    private static final By CONTINUE = By.id("continue");
    private static final By CANCEL = By.id("cancel");
    private static final By PROD_NAME = By.cssSelector("[data-test='inventory-item-name']");
    private static final By OUT_TITLE = By.cssSelector("[data-test='title']");
    private static final By FINISH = By.name("finish");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");

    public String getTitle() {
        return driver.findElement(OUT_TITLE).getText();
    }

    public void finishCheckOut(){
        driver.findElement(FINISH).click();
    }

    public void checkProductInCart(){
        driver.findElement(PROD_NAME);
    }
    public void sendKeys(String firstname, String lastname, String zipcode) {
        driver.findElement(FIRST_NAME).sendKeys(firstname);
        driver.findElement(LAST_NAME).sendKeys(lastname);
        driver.findElement(ZIP_CODE).sendKeys(zipcode);
    }

    public void clickContinue() {
        driver.findElement(CONTINUE).click();
    }

    public void clickCancel() {
        driver.findElement(CANCEL).click();
    }

    public String errorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWorkLocators {

    @Test
    public void locators(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Поиск по id
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        //Поиск по xpath
        driver.findElement(By.xpath("//*[@id='header_container']"));
        //Поиск по className
        driver.findElement(By.className("title"));
        //Поиск по tagName
        driver.findElement(By.tagName("img"));
        //Поиск по linkText
        driver.findElement(By.linkText("Sauce Labs Onesie"));
        //Поиск по CSS selector
        driver.findElement(By.cssSelector("#header_container > div.primary_header > div.header_label > div"));



        driver.quit();
    }

}

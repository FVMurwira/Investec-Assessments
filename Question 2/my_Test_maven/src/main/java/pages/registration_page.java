package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registration_page {

    private final WebDriver driver;

    public registration_page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement mainHeading() {
        return driver.findElement(By.tagName("h1"));
    }



}

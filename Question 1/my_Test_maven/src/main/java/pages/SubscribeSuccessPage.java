package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubscribeSuccessPage {
    private final WebDriver driver;

    public SubscribeSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement mainHeading() {
        return driver.findElement(By.tagName("h1"));
    }

    public void assertSubscribeSuccessPage() {
        Assertions.assertEquals("We look forward to sharing out of the ordinary insights with you!", mainHeading().getText().trim());
    }
}

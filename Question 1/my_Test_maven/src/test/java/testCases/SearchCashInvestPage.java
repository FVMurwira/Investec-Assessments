package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.registration_page;

public class SearchCashInvestPage {
    private WebDriver driver;
    private registration_page homepagenv;


    @BeforeAll
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        homepagenv = new registration_page(driver);
    }

    // Search for required
    @Test
    public void doSearchBar() {
        homepagenv.openSearch();
        WebElement el = driver.findElement(By.tagName("h1"));
        String elStr = el.getText();
        Assertions.assertEquals("Understanding cash investment interest rates", elStr);
    }
}

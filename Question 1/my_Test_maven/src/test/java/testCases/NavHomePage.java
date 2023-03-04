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
import pages.SubscribeSuccessPage;
import pages.registration_page;

public class NavHomePage {

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

    // check main header navigation
    @Test
    public void openHomePage() {

        homepagenv.navToHomePage();
        WebElement el = driver.findElement(By.tagName("h3"));
        String elStr = el.getText();
        String elStrSub = elStr.substring(0,8);
        Assertions.assertEquals("Investec", elStrSub);
        //Assertions.assertEquals("Investec is a distinctive bank and wealth manager", );

    }

}

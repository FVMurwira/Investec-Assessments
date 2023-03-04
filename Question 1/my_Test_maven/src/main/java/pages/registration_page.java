package pages;

import models.client;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import lombok.var;


public class registration_page {

    private final WebDriver driver;

    public registration_page(WebDriver driver) {
        this.driver = driver;
    }
//
//    public WebElement mainHeading() {
//        return driver.findElement(By.tagName("h1"));
//    }

    public void open() {
        driver.navigate().to(" https://www.investec.com/");
    }

    public void openSearch() {
        driver.navigate().to("https://www.investec.com/en_za/focus/money/understanding-interest-rates.html");
    }

    public void receiveFocusInsights()

    {
        driver.navigate().to("https://www.investec.com/en_za/focus.html?section=Focus%20insights");
    }

    public WebElement findHeader() {
        return driver.findElement(By.tagName("h1"));
    }

    public WebElement findFocusDataHeader() {
        return driver.findElement(By.tagName("h4"));
    }

    public WebElement searchButton() {
        return driver.findElement(By.xpath("//input[@value='Continue']"));
    }

    public WebElement subButton() {
        return driver.findElement(By.xpath("//button[@class='forms__submit cta-primary']"));
    }

    public void navToHomePage() {

        driver.navigate().to("https://www.investec.com/");
    }

    public void navToSearch() {

        driver.navigate().to("https://www.investec.com/");
    }


    public WebElement searchInput() {
        return driver.findElement(By.id("searchBarInput"));
    }
    public void navToFocusInsights() {
        driver.navigate().to("https://www.investec.com/en_za/focus.html?section=Focus%20insights");
    }

    public WebElement fistNameInput() {
        return driver.findElement(By.id("input-firstname"));
    }
    public WebElement fistNameLabel() {
        return driver.findElement(By.xpath("//label[@for='name']"));
    }


    public WebElement lastNameInput() {
        return driver.findElement(By.id("input-lastname"));
    }

    public WebElement lastNameLabel() {
        return driver.findElement(By.xpath("//label[@for='input-lastname']"));
    }

    public WebElement emailInput() {
        return driver.findElement(By.id("input-email"));
    }

    public WebElement emailLabel() {
        return driver.findElement(By.xpath("//label[@for='input-email']"));
    }

    public WebElement myself() {
        return driver.findElement(By.id("input-newsletter-yes"));
    }

    public WebElement intermediaries() {
        return driver.findElement(By.id("input-newsletter-no"));
    }

    public WebElement mybusiness() {
        return driver.findElement(By.id("input-newsletter-no"));
    }

    public void signup (client cl, Boolean useEnter) {
        if (!cl.getFirstName().isEmpty()) {
            fistNameInput().sendKeys(cl.getFirstName());
        }

        if (!cl.getLastName().isEmpty()) {
            lastNameInput().sendKeys(cl.getLastName());
        }

        if (!cl.getEmail().isEmpty()) {
            emailInput().sendKeys(cl.getEmail());
        }

        if (cl.getMySelf() || cl.getInterMediaries() || cl.getMyBusiness()) {
            //clSubscribedYes().click();
        } else {
            //autoSubscribe().click();
        }

        if (useEnter)
        {
            subButton().sendKeys(Keys.ENTER);
        } else
        {
            subButton().click();
        }
    }



}

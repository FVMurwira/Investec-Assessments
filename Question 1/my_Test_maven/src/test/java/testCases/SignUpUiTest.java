package testCases;

import factories.ClientFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.var;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v95.log.Log;
import pages.SubscribeSuccessPage;
import pages.registration_page;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SignUpUiTest {

    private WebDriver driver;
    private registration_page focusdatapage;
    private SubscribeSuccessPage subscribesuccesspage;
    private SubscribeSuccessPage signuppage;
    private List<JavascriptException> jsExceptionsList;
    private List<String> consoleMessages;


    @BeforeAll
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
    driver = new ChromeDriver();
    //subscribesuccesspage = new registration_page(driver);
    focusdatapage = new registration_page(driver);
    //subscribesuccesspage = new registration_page(driver);
    signuppage = new SubscribeSuccessPage(driver);

    DevTools devTools = ((HasDevTools) driver).getDevTools();
    devTools.createSession();

    // configure JS exceptions logging
    jsExceptionsList =new ArrayList<>();
    Consumer<JavascriptException> addEntry = jsExceptionsList::add;
    devTools.getDomains().events().addJavascriptExceptionListener(addEntry);

    // configure console messages logging
    List<String> consoleMessages = new ArrayList<>();
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(),
            logEntry -> {
                consoleMessages.add("log: " + logEntry.getText() + "level: " + logEntry.getLevel());
            });
    }

    @Test
    public void clSignUpSuccess() {
        var cl = ClientFactory.createDefault();

        focusdatapage.navToFocusInsights();
        focusdatapage.signup(cl, true);

        signuppage.assertSubscribeSuccessPage();
    }

    // Test Sign up to receive focus insights straight to your inbox
    // Sign up to receive focus insights straight to your inbox
    @Test
    public void testSignupFocusData() {
        String elStr = "input";

        focusdatapage.navToFocusInsights();
        //Automate Capture Name
        List<WebElement> nam = driver.findElements(By.xpath("//div[@class='text-input__input-holder text-input__input-holder--animated']"));

        for (WebElement el : nam) {
            System.out.println("Element text is: " + el.getTagName() + " " + el.getText());
            if (el.getTagName().toString().equals(elStr)) {
                el.clear();
                el.click();
                el.sendKeys("MyTestName");
            }
        }
        //Automate Capture Surname
        List<WebElement> surnam = driver.findElements(By.xpath("//div[@class='text-input__input ng-valid-pattern ng-valid-minlength ng-valid-maxlength text-input__input--animated ng-not-empty ng-dirty ng-valid-parse ng-valid ng-valid-required text-input__input--has-content ng-touched']"));

        for (WebElement el : surnam) {
            System.out.println("Element text is: " + el.getTagName() + " " + el.getText());
            if (el.getTagName().toString().equals(elStr)) {
                el.clear();
                el.click();
                el.sendKeys("MyTestSurName");
            }
        }
        //Automate Capture Email
        List<WebElement> myemail = driver.findElements(By.xpath("//div[@class='text-input__input ng-valid-minlength ng-valid-maxlength text-input__input--animated ng-not-empty ng-dirty ng-valid-parse ng-valid-required ng-valid-email ng-valid ng-valid-pattern text-input__input--has-content ng-touched']"));

        for (WebElement el : myemail) {
            System.out.println("Element text is: " + el.getTagName() + " " + el.getText());
            if (el.getTagName().toString().equals(elStr)) {
                el.clear();
                el.click();
                el.sendKeys("test@investec.co.za");
            }
        }


    }
}


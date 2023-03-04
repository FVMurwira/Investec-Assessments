package testCases;

import factories.ClientFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.var;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v95.log.Log;
import pages.SubscribeSuccessPage;
import pages.registration_page;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestSignUpSuccess {


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

}

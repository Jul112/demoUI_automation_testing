package tests;

import config.DriverConfig;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;

public class TestBase {
    static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {

        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = driverConfig.getWebBrowser();
        Configuration.downloadsFolder = "./src/test/resources/privacy_policy";
        Configuration.reportsFolder = "./src/test/resources/vacancy_screenshot";


        if(driverConfig.getRemoteWebDriver() != null) {
            String user = driverConfig.getRemoteWebUser();
            String password = driverConfig.getRemoteWebPassword();
            Configuration.remote = String.format(driverConfig.getRemoteWebDriver(), user, password);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if(System.getProperty("video.storage") != null) {
            attachVideo();
        }
        closeWebDriver();
    }
}

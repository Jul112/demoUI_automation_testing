package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.DriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static java.lang.String.join;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverHelper {
    private static DriverConfig driverConfig = ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());

    public static String getWebRemoteDriver() {
        return String.format(driverConfig.getRemoteWebDriver(),
                driverConfig.getRemoteWebUser(),
                driverConfig.getRemoteWebPassword());
    }

    public static boolean isRemoteWebDriver() {
        return !driverConfig.getRemoteWebDriver().equals("");
    }

    public static String getVideoUrl() {
        return driverConfig.getVideoStorage();
    }

    public static boolean isVideoOn() {
        return getVideoUrl().equals("");
    }

    public static String getSessionId(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid","");
    }

    public static String getConsoleLogs() {
        return join("\n", getWebDriverLogs(BROWSER));
    }

    public static void configureDriver() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = driverConfig.getWebBrowser();
        Configuration.timeout = 4000;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = getWebRemoteDriver();
        }

        Configuration.browserCapabilities = capabilities;
    }
}
package helpers;

import com.codeborne.selenide.Configuration;
import com.google.common.collect.ImmutableMap;
import config.DriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.join;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverHelper {
    private static DriverConfig getDriverConfig() {
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
    }

    public static String getWebRemoteDriver() {
        return String.format(getDriverConfig().getRemoteWebDriver(),
                getDriverConfig().getRemoteWebUser(),
                getDriverConfig().getRemoteWebPassword());
    }

    public static boolean isRemoteWebDriver() {
        return !getDriverConfig().getRemoteWebDriver().equals("");
    }

    public static String getVideoUrl() {
        return getDriverConfig().getVideoStorage();
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
        Configuration.browser = getDriverConfig().getWebBrowser();
        Configuration.timeout = 4000;
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", getDriverConfig().getWebBrowser())
                        .put("URL", "http://epam-group.ru")
                        .build(), System.getProperty("user.dir")
                        + "/build/allure-results/");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = getWebRemoteDriver();
        }

        Configuration.browserCapabilities = capabilities;
    }
}

package tests;

import com.codeborne.selenide.Configuration;
import helpers.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        DriverHelper.configureDriver();
    }

    @BeforeEach
    void settingsBrowser() {
        Configuration.startMaximized = true;

    }

    @AfterEach
    void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if(System.getProperty("video.storage") != null) {
            attachVideo();
        }
        closeWebDriver();
    }
}

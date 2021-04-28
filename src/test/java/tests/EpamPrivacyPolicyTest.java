package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

@Feature("Privacy policy")
public class EpamPrivacyPolicyTest extends TestBase{
    BaseSteps steps = new BaseSteps();
    SelenideElement element = $("[href='https://www.epam-group.ru/content/dam/epam/ru/privacy-policy/Personal_Data_Processing_RU.pdf']");
    String fileName = "Personal_Data_Processing_RU.pdf";

    @Test
    @Tag("positive")
    @Story("Processing of personal data")
    @DisplayName("Check the download file with the consent to the processing of personal data")
    public void downloadFileWithConsentTest() throws FileNotFoundException {
        steps.openMainPage();
        steps.downloadFilefromPrivacyPolicyPage(element, fileName);
    }
}

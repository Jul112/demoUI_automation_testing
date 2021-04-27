package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseSteps {

    @Step("Open main page of EPAM group")
    public void openMainPage() {
        open("https://www.epam-group.ru");
        $("[aria-label='Accept our use of cookies']").click();
    }

    @Step("Click on last slider-navigation button")
    public void clickSliderButton() {
        $(".slider-ui").scrollTo();
        $$(".slider__navigation button").last().click();
        $(withText("EPAM Continuum")).shouldBe(visible);
    }

    @Step("Download file with the consent to the processing of personal data")
    public void downloadFilefromPrivacyPolicyPage(SelenideElement element, String fileName) throws FileNotFoundException {
        openPrivacyPolicyPage();
        downloadFile(element, fileName);
    }
    public void openPrivacyPolicyPage() {
        $(".footer-container").scrollTo();
        $$("ul.footer__links").last().click();
    }
    public void downloadFile(SelenideElement element, String fileName) throws FileNotFoundException {
        File downloadedFile = element.download();
        assertThat(downloadedFile.getName()).isEqualTo(fileName);
    }

    @Step("Search suitable vacancy on career page")
    public void searchVacancy(String jobLevelNotForMe, String programmingLanguage) {
        $("[href='https://www.epam-group.ru/careers']").click();
        Selenide.executeJavaScript("($('.recruiting-search__input').val('qa automation'))");
        Selenide.executeJavaScript("($('button[type=submit]').click())");
        $(".search-result ul h5 a").shouldNotHave(text(jobLevelNotForMe)).click();
        $(".vacancy_content").shouldHave(text(programmingLanguage));
    }

    @Step("Get screenshot")
    public void getScreenshot(String name) {
        String pngVacancy = screenshot(name);
    }

    @Step("Select English language")
    public void selectLanguage(SelenideElement language) {
        $(".location-selector-ui button").click();
        language.click();
        sleep(6000);
        $(".section-ui h2 span").shouldHave(text("Engineering the Future"));
    }
}

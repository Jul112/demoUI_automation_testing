package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseSteps {
    static File downloadedFile;

    @Step("Open main page of EPAM group")
    public void openMainPage() {
        open("https://www.epam-group.ru");
        $("[aria-label='Accept our use of cookies']").click();
    }
    @Step("Click on last slider-navigation button")
    public void clickSliderButton() {
        $(".slider-ui").scrollTo();
        $$(".slider__navigation button").last().click();
    }
    @Step("Verify that the slider screen has changed")
    public void checkSliderScreen(String sliderScreenText) {
        $(withText(sliderScreenText)).shouldBe(visible);
    }
    @Step("Open page with Privacy Policy")
    public void openPrivacyPolicyPage() {
        openMainPage();
        $(".footer-container").scrollTo();
        $$("ul.footer__links").last().click();
    }
    @Step("Download file with the consent to the processing of personal data")
    public void downloadFileFromPrivacyPolicyPage(SelenideElement element) throws FileNotFoundException {
        downloadedFile = element.download();
    }
    @Step("Verify that file has downloaded")
    public void checkDownloadedFile(String fileName) {
        assertThat(downloadedFile.getName()).isEqualTo(fileName);
    }
    @Step("Search vacancy on career page")
    public void searchVacancy() {
        $("[href='https://www.epam-group.ru/careers']").click();
        Selenide.executeJavaScript("($('.recruiting-search__input').val('qa automation'))");
        Selenide.executeJavaScript("($('button[type=submit]').click())");
    }
    @Step("Open suitable vacancy")
    public void openSuitableVacancy(String jobLevelNotForMe) {
        SelenideElement element = $(".search-result ul h5 a").shouldNotHave(text(jobLevelNotForMe));
        if(element.exists()) {
            element.click();
            getScreenshot("vacancy_for_me");
        } else System.out.println("No vacancies for me");
    }
    @Step("Search a vacancy on career page")
    public void searchSomeVacancy() {
        $("[href='https://www.epam-group.ru/careers']").click();
        Selenide.executeJavaScript("($('.recruiting-search__input').val('qa automation'))");
        Selenide.executeJavaScript("($('button[type=submit]').click())");
    }
    @Step("Verify that the invalid vacancy does not exist")
    public void checkSearchInvalidVacancy(String jobLevel) {
        $(".search-result ul h5 a").shouldHave(text(jobLevel));
    }
    @Step("Get screenshot")
    public void getScreenshot(String name) {
        Selenide.screenshot(name);
    }
    @Step("Select other language")
    public void selectLanguage(SelenideElement language) {
        $(".location-selector-ui button").click();
        language.click();
    }
    @Step("Verify that language has changed")
    public void checkChangedLanguage(String anotherLanguageText) {
        $(".section-ui h2 span").shouldHave(text(anotherLanguageText));
    }
}

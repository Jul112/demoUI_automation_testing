package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

@Feature("Location")
public class EpamSelectLanguageTest extends TestBase{
    BaseSteps steps = new BaseSteps();
    SelenideElement englishLang = $("a[lang=en]");
    SelenideElement greekLang = $("a[lang=gr]");

    @Test
    @Tag("web")
    @Story("Select languages")
    @DisplayName("Select language on main page")
    public void selectLanguage() {
        steps.openMainPage();
        steps.selectLanguage(englishLang);
    }

    @Test
    @Tag("negative")
    @Story("Select languages")
    @DisplayName("Select missing language on main page")
    public void selectIncorrectLanguage() {
        steps.openMainPage();
        steps.selectLanguage(greekLang);
    }
}

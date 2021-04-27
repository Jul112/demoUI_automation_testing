package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Career")
public class EpamSearchVacancyTest extends TestBase{
    BaseSteps steps = new BaseSteps();
    String jobLevelNotForMe = "Senior";
    String badJob = "BadJob";
    String programmingLanguage = "java";
    String screenshotName = "vacancy";

    @Test
    @Tag("web")
    @Story("Vacancies")
    @DisplayName("Search for a suitable vacancy")
    public void searchForVacancyTest() {
        steps.openMainPage();
        steps.searchVacancy(jobLevelNotForMe, programmingLanguage);
        steps.getScreenshot(screenshotName);
    }

    @Test
    @Tag("negative")
    @Story("Vacancies")
    @DisplayName("Search for an incorrect vacancy")
    public void searchForIncorrectVacancyTest() {
        steps.openMainPage();
        steps.searchVacancy(badJob, programmingLanguage);
        steps.getScreenshot(screenshotName);
    }
}

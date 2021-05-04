package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Career")
public class SearchVacancyTest extends TestBase{
    BaseSteps steps = new BaseSteps();
    String jobLevelNotForMe = "Senior";
    String badJob = "BadJob";
    String screenshotName = "vacancy";

    @Test
    @Tag("positive")
    @Story("Vacancies")
    @DisplayName("Search for a suitable vacancy with screenshot")
    public void searchForVacancyTest() {
        steps.openMainPage();
        steps.searchVacancy();
        steps.openSuitableVacancy(jobLevelNotForMe);
    }

    @Test
    @Tag("negative")
    @Story("Vacancies")
    @DisplayName("Search for an incorrect vacancy")
    public void searchForIncorrectVacancyTest() {
        steps.openMainPage();
        steps.searchSomeVacancy();
        steps.checkSearchInvalidVacancy(badJob);
    }
}

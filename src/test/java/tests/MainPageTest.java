package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Main page")
public class MainPageTest extends TestBase{
    BaseSteps steps = new BaseSteps();
    String sliderScreenText = "EPAM Continuum";

    @Test
    @Tag("positive")
    @Story("Check slider")
    @DisplayName("Check slider's button on main page")
    public void checkSliderTest() {
        steps.openMainPage();
        steps.clickSliderButton();
        steps.checkSliderScreen(sliderScreenText);
    }
}
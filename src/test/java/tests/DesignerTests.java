package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.stellarburgers.pageobjects.DesignerPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class DesignerTests {

    @Test
    @DisplayName("choose bun on construcor")
    public void chooseBunOnConstructor() {

        DesignerPage designerPage = open(DesignerPage.URL_OPEN, DesignerPage.class)
                .clickBunsButton();

        assertTrue(designerPage.checkBunIsDisplayed());
    }

    @Test
    @DisplayName("choose sauce on constructor")
    public void chooseSauceOnConstructor() {

        DesignerPage designerPage = open(DesignerPage.URL_OPEN, DesignerPage.class)
                .clickSauceButton();

        assertTrue(designerPage.checkSauceIsDisplayed());
    }

    @Test
    @DisplayName("choose main on constructor")
    public void chooseMainOnConstructor() {

        DesignerPage designerPage = open(DesignerPage.URL_OPEN, DesignerPage.class)
                .clickMainButton();

        assertTrue(designerPage.checkMainIsDisplayed());
    }
}

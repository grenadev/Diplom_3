package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.stellarburgers.PageObjects.DesignerPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class DesignerTests {

    @Test
    @DisplayName("choose bun on construcor")
    public void chooseBunOnConstructor() {

        DesignerPage designerPage = open(DesignerPage.urlOpen, DesignerPage.class)
                .clickBunsButton();

        assertTrue(designerPage.bunSection.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed());
    }

    @Test
    @DisplayName("choose sauce on constructor")
    public void chooseSauceOnConstructor() {

        DesignerPage designerPage = open(DesignerPage.urlOpen, DesignerPage.class)
                .clickSauceButton();

        assertTrue(designerPage.sauceSection.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed());
    }

    @Test
    @DisplayName("choose main on constructor")
    public void chooseMainOnConstructor() {

        DesignerPage designerPage = open(DesignerPage.urlOpen, DesignerPage.class)
                .clickMainButton();

        assertTrue(designerPage.mainSection.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed());
    }
}

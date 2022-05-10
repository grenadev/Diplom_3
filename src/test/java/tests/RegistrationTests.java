package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import ru.stellarburgers.PageObjects.LoginPage;
import ru.stellarburgers.PageObjects.RegistrationPage;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class RegistrationTests extends BaseTest {

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("registration with random mail")
    public void registrationTest() {

        LoginPage loginPage = open(RegistrationPage.urlOpen, RegistrationPage.class)
                .setNameRegPage("Name")
                .setEmailRegPage(RandomStringUtils.randomAlphabetic(10) + "@mail.ru")
                .setPasswordRegPage("SecretPassword123")
                .clickAccept();

        assertTrue(loginPage.registerButton.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed());
    }

    @Test
    @DisplayName("registration with short password")
    public void registrationWithShortPasswordTest() {
        LoginPage loginPage = open(RegistrationPage.urlOpen, RegistrationPage.class)
                .setNameRegPage("Name")
                .setEmailRegPage(RandomStringUtils.randomAlphabetic(10) + "@mail.ru")
                .setPasswordRegPage("123")
                .clickAccept();

        assertTrue($(byText("Некорректный пароль")).isDisplayed());
    }
}

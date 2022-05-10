package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stellarburgers.PageObjects.*;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfileTest {

    private static String email;
    private static String password;
    private static boolean initialized = false;

    @Before
    public void setUp() {
        if (!initialized) {
            email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
            password = RandomStringUtils.randomAlphabetic(10);
            RegistrationPage registrationPage = new RegistrationPage();
            registrationPage.registrationNewAccount(email, password);
            initialized = true;
        }
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("open profile from header after login")
    public void openProfileUserTest() {

        ProfilePage profilePage = open(MainPage.urlOpen, MainPage.class)
                .clickToLoginFromHeader()
                .setEmail(email)
                .setPassword(password)
                .clickToLoginOnLoginPage()
                .clickToLoginFromHeaderAfterLogin();

        assertEquals(profilePage.fieldLogin.getValue(), email.toLowerCase());
    }

    @Test
    @DisplayName("logout from profile")
    public void logoutFromProfileUserTest() {

        LoginPage loginPage = open(MainPage.urlOpen, MainPage.class)
                .clickToLoginFromHeader()
                .setEmail(email)
                .setPassword(password)
                .clickToLoginOnLoginPage()
                .clickToLoginFromHeaderAfterLogin()
                .clickLogoutButton();

        assertTrue(loginPage.registerButton.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed());
    }

    @Test
    @DisplayName("from icon to designer ")
    public void FromIconToDesignerTest() {
        DesignerPage designerPage = open(MainPage.urlOpen, MainPage.class)
                .clickToLoginFromHeader()
                .setEmail(email)
                .setPassword(password)
                .clickToLoginOnLoginPage()
                .clickToLoginFromHeaderAfterLogin()
                .clickBurgerIcon();

        assertTrue(designerPage.burgerLabel.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed());
    }

    @Test
    @DisplayName("from header to designer")
    public void fromHeaderToDesignerTest() {
        DesignerPage designerPage = open(MainPage.urlOpen, MainPage.class)
                .clickToLoginFromHeader()
                .setEmail(email)
                .setPassword(password)
                .clickToLoginOnLoginPage()
                .clickToLoginFromHeaderAfterLogin()
                .clickDesignerButton();

        assertTrue(designerPage.burgerLabel.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed());
    }
}

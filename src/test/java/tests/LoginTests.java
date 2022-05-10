package tests;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import ru.stellarburgers.PageObjects.ForgotPasswordPage;
import ru.stellarburgers.PageObjects.MainPage;
import ru.stellarburgers.PageObjects.RegistrationPage;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

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
    @DisplayName("login from header")
    public void loginFromHeader() {

        MainPage mainPage = open(MainPage.urlOpen, MainPage.class)
                .clickToLoginFromHeader()
                .setEmail(email)
                .setPassword(password)
                .clickToLoginOnLoginPage();

        mainPage.waitForLoadAfterLogin();
        assertTrue(mainPage.createOrderButton.isDisplayed());
    }

    @Test
    @DisplayName("login from main page")
    public void loginFromMainPage() throws InterruptedException {
        MainPage mainPage = open(MainPage.urlOpen, MainPage.class)
                .clickToLoginMainPage()
                .setEmail(email)
                .setPassword(password)
                .clickToLoginOnLoginPage();

        mainPage.waitForLoadAfterLogin();
        assertTrue(mainPage.createOrderButton.isDisplayed());
    }

    @Test
    @DisplayName("login from forgot password")
    public void loginFromForgotPassword() {
        MainPage mainPage = open(ForgotPasswordPage.urlOpen, ForgotPasswordPage.class)
                .clickLoginForgotPage()
                .setEmail(email)
                .setPassword(password)
                .clickToLoginOnLoginPage();

        mainPage.waitForLoadAfterLogin();
        assertTrue(mainPage.createOrderButton.isDisplayed());
    }

    @Test
    @DisplayName("login from registration")
    public void loginFromRegistration() {
        MainPage mainPage = open(RegistrationPage.urlOpen, RegistrationPage.class)
                .clickLoginRegPage()
                .setEmail(email)
                .setPassword(password)
                .clickToLoginOnLoginPage();

        mainPage.waitForLoadAfterLogin();
        assertTrue(mainPage.createOrderButton.isDisplayed());
    }
}


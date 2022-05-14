package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import ru.stellarburgers.client.UserClient;
import ru.stellarburgers.model.User;
import ru.stellarburgers.pageobjects.ForgotPasswordPage;
import ru.stellarburgers.pageobjects.MainPage;
import ru.stellarburgers.pageobjects.RegistrationPage;
import ru.stellarburgers.utils.UserDataGenerator;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    private static User user;
    private static UserClient userClient;
    String auth;


    @BeforeClass
    public static void setUp() {
        userClient = new UserClient();
        user = UserDataGenerator.generateUserData();
    }

    @Before
    public void setUpTests() {
        auth = userClient.createNewUser(user).extract().body().path("accessToken");
    }


    @After
    public void tearDown() {
        webdriver().driver().close();
        if (auth != null) {
            userClient.deleteUser(auth);
        }
    }



    @Test
    @DisplayName("login from header")
    public void loginFromHeader() {

        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickToLoginFromHeader()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickToLoginOnLoginPage();

        mainPage.waitForLoadAfterLogin();
        assertTrue(mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("login from main page")
    public void loginFromMainPage() throws InterruptedException {


        MainPage mainPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickToLoginMainPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickToLoginOnLoginPage();

        mainPage.waitForLoadAfterLogin();
        assertTrue(mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("login from forgot password")
    public void loginFromForgotPassword() {


        MainPage mainPage = open(ForgotPasswordPage.URL_OPEN, ForgotPasswordPage.class)
                .clickLoginForgotPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickToLoginOnLoginPage();

        mainPage.waitForLoadAfterLogin();
        assertTrue(mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("login from registration")
    public void loginFromRegistration() {


        MainPage mainPage = open(RegistrationPage.URL_OPEN, RegistrationPage.class)
                .clickLoginRegPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickToLoginOnLoginPage();

        mainPage.waitForLoadAfterLogin();
        assertTrue(mainPage.checkOrderButton());
    }
}


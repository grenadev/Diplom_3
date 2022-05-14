package tests;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.stellarburgers.client.UserClient;
import ru.stellarburgers.model.User;
import ru.stellarburgers.pageobjects.LoginPage;
import ru.stellarburgers.pageobjects.RegistrationPage;
import ru.stellarburgers.utils.UserDataGenerator;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class RegistrationTests extends BaseTest {

    private static User user;
    private static UserClient userClient;
    String auth;


    @BeforeClass
    public static void setUp() {
        userClient = new UserClient();
        user = UserDataGenerator.generateUserData();
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
        if (auth != null) {
            userClient.deleteUser(auth);
        }
    }

    @Test
    @DisplayName("registration with random mail")
    public void registrationTest() {

        LoginPage loginPage = open(RegistrationPage.URL_OPEN, RegistrationPage.class)
                .setNameRegPage(user.getName())
                .setEmailRegPage(user.getEmail())
                .setPasswordRegPage(user.getPassword())
                .clickAccept();

        assertTrue(loginPage.checkRegisterButton());

        auth = userClient.loginUser(user).extract().body().path("accessToken");
    }

    @Test
    @DisplayName("registration with short password")
    public void registrationWithShortPasswordTest() {
        LoginPage loginPage = open(RegistrationPage.URL_OPEN, RegistrationPage.class)
                .setNameRegPage(user.getName())
                .setEmailRegPage(user.getEmail())
                .setPasswordRegPage("123")
                .clickAccept();

        assertTrue($(byText("Некорректный пароль")).isDisplayed());

        if (userClient.loginUser(user).extract().statusCode() == 200) {
            auth = userClient.loginUser(user).extract().body().path("accessToken");

        }
    }
}

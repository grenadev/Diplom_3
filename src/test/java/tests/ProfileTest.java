package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.stellarburgers.client.UserClient;
import ru.stellarburgers.model.User;
import ru.stellarburgers.pageobjects.*;
import ru.stellarburgers.utils.UserDataGenerator;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfileTest {

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
    @DisplayName("open profile from header after login")
    public void openProfileUserTest() {

        auth = userClient.createNewUser(user).extract().body().path("accessToken");

        ProfilePage profilePage = open(MainPage.URL_OPEN, MainPage.class)
                .clickToLoginFromHeader()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickToLoginOnLoginPage()
                .clickToLoginFromHeaderAfterLogin();

        assertEquals(profilePage.getValueFieldLogin(), user.getEmail().toLowerCase());
    }

    @Test
    @DisplayName("logout from profile")
    public void logoutFromProfileUserTest() {

        auth = userClient.createNewUser(user).extract().body().path("accessToken");

        LoginPage loginPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickToLoginFromHeader()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickToLoginOnLoginPage()
                .clickToLoginFromHeaderAfterLogin()
                .clickLogoutButton();

        assertTrue(loginPage.checkRegisterButton());
    }

    @Test
    @DisplayName("from icon to designer ")
    public void FromIconToDesignerTest() {

        auth = userClient.createNewUser(user).extract().body().path("accessToken");

        DesignerPage designerPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickToLoginFromHeader()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickToLoginOnLoginPage()
                .clickToLoginFromHeaderAfterLogin()
                .clickBurgerIcon();

        assertTrue(designerPage.checkBurgerLabel());
    }

    @Test
    @DisplayName("from header to designer")
    public void fromHeaderToDesignerTest() {

        auth = userClient.createNewUser(user).extract().body().path("accessToken");

        DesignerPage designerPage = open(MainPage.URL_OPEN, MainPage.class)
                .clickToLoginFromHeader()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickToLoginOnLoginPage()
                .clickToLoginFromHeaderAfterLogin()
                .clickDesignerButton();

        assertTrue(designerPage.checkBurgerLabel());
    }
}

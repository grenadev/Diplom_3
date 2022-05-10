package ru.stellarburgers.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;


public class LoginPage {

    public static String urlRegistration = "https://stellarburgers.nomoreparties.site/login";


    //локатор поля "Email"
    @FindBy(how = How.CSS, using = "fieldset:nth-child(1) > div > div > input")
    public SelenideElement emailField;

    //локатор поля "Пароль"
    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) > div > div > input")
    public SelenideElement passwordField;

    //локатор кнопки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    public SelenideElement forgotButton;

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    public SelenideElement loginButton;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    public SelenideElement registerButton;

    public LoginPage setEmail(String email) {
        emailField.shouldBe(Condition.visible, Duration.ofSeconds(8));
        this.emailField.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        this.passwordField.sendKeys(password);
        return this;
    }

    public ForgotPasswordPage clickForgotPassword() {
        this.forgotButton.click();
        return Selenide.page(ForgotPasswordPage.class);
    }

    public MainPage clickToLoginOnLoginPage() {
        this.loginButton.click();
        return Selenide.page(MainPage.class);
    }
}

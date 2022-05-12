package ru.stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;


public class LoginPage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/login";


    //локатор поля "Email"
    @FindBy(how = How.CSS, using = "fieldset:nth-child(1) > div > div > input")
    private SelenideElement emailField;

    //локатор поля "Пароль"
    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) > div > div > input")
    private SelenideElement passwordField;

    //локатор кнопки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    private SelenideElement forgotButton;

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement loginButton;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

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

    public boolean checkRegisterButton() {
        return registerButton.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

}

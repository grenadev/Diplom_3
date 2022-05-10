package ru.stellarburgers.PageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class RegistrationPage {

    public static String urlOpen = "https://stellarburgers.nomoreparties.site/register";


    //локатор поля "Имя"
    @FindBy(how = How.CSS, using = "fieldset:nth-child(1) > div > div > input")
    public SelenideElement nameField;

    //локатор поля "Email"
    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) > div > div > input")
    public SelenideElement emailField;

    //локатор поля "Пароль"
    @FindBy(how = How.CSS, using = "fieldset:nth-child(3) > div > div > input")
    public SelenideElement passwordField;

    //локатор лейбла "Ошибка при вводе пароля"
    @FindBy(how = How.CSS, using = "fieldset:nth-child(3) > div > p")
    public SelenideElement passwordError;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    public SelenideElement registrationButton;

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    public SelenideElement loginButton;

    public RegistrationPage setNameRegPage(String name) {
        this.nameField.sendKeys(name);
        return this;
    }

    public RegistrationPage setEmailRegPage(String email) {
        this.emailField.sendKeys(email);
        return this;
    }

    public RegistrationPage setPasswordRegPage(String password) {
        this.passwordField.sendKeys(password);
        return this;
    }

        public LoginPage clickAccept() {
        this.registrationButton.click();
        return Selenide.page(LoginPage.class);
    }

    public LoginPage clickLoginRegPage() {
        this.loginButton.click();
        return Selenide.page(LoginPage.class);
    }

    public void registrationNewAccount(String email, String password) {
        LoginPage loginPage = Selenide.open(RegistrationPage.urlOpen, RegistrationPage.class)
                .setNameRegPage("Name")
                .setEmailRegPage(email)
                .setPasswordRegPage(password)
                .clickAccept();
    }
}

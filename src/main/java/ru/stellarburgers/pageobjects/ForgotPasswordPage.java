package ru.stellarburgers.pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/forgot-password";

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement loginButton;

    public LoginPage clickLoginForgotPage() {
        this.loginButton.click();
        return Selenide.page(LoginPage.class);
    }
}

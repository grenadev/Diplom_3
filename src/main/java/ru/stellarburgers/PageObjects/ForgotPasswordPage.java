package ru.stellarburgers.PageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    public static String urlOpen = "https://stellarburgers.nomoreparties.site/forgot-password";

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    public SelenideElement loginButton;

    public LoginPage clickLoginForgotPage() {
        this.loginButton.click();
        return Selenide.page(LoginPage.class);
    }
}

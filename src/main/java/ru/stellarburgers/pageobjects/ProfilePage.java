package ru.stellarburgers.pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/account/profile";

    //локатор кнопки "Выйти"
    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement logoutButton;

    //локатор поля "Имя"
    @FindBy(how = How.CSS, using = "li:nth-child(1) div>div>input")
    private SelenideElement fieldName;

    //локатор поля "Логин"
    @FindBy(how = How.CSS, using = "li:nth-child(2) div>div>input")
    private SelenideElement fieldLogin;

    //локатор поля "Пароль"
    @FindBy(how = How.CSS, using = "li:nth-child(3) div>div>input")
    private SelenideElement fieldPassword;

    //локатор икнонки stellarburgers в хедере
    @FindBy(how = How.CSS, using = "header>nav>div>a")
    private SelenideElement burgerIcon;

    //локатор кнопки "Конструктор" в хедере
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement designerButton;

    public String getValueFieldLogin () {
        return fieldLogin.getValue();
    }

    public DesignerPage clickBurgerIcon() {
        this.burgerIcon.click();
        return Selenide.page(DesignerPage.class);
    }

    public DesignerPage clickDesignerButton() {
        this.designerButton.click();
        return Selenide.page(DesignerPage.class);
    }

    public LoginPage clickLogoutButton() {
        this.logoutButton.click();
        return Selenide.page(LoginPage.class);
    }
}

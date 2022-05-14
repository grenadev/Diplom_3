package ru.stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/";

    //локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement loginToAccount;

    //локатор кнопки "Личный кабинет"
    @FindBy(how = How.CSS, using = "div>header>nav>a>p")
    private SelenideElement loginToAccountFromHeader;

    //локатор кнопки "Оформить заказ"
    @FindBy(how = How.CSS, using = "section.BurgerConstructor_basket__29Cd7.mt-25>div>button")
    private SelenideElement createOrderButton;


    public boolean checkOrderButton() {
        return createOrderButton.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public LoginPage clickToLoginMainPage() {
        this.loginToAccount.click();
        return Selenide.page(LoginPage.class);
    }

    public LoginPage clickToLoginFromHeader() {
        this.loginToAccountFromHeader.click();
        return Selenide.page(LoginPage.class);
    }

    public ProfilePage clickToLoginFromHeaderAfterLogin() {
        this.loginToAccountFromHeader.click();
        return Selenide.page(ProfilePage.class);
    }


    public void waitForLoadAfterLogin() {
        createOrderButton.shouldBe(Condition.visible, Duration.ofSeconds(8));
    }
}

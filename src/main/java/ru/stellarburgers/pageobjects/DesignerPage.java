package ru.stellarburgers.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class DesignerPage {

    public static final String URL_OPEN = "https://stellarburgers.nomoreparties.site/";

    //локатор икнонки stellarburgers в хедере
    @FindBy(how = How.CSS, using = "header>nav>div>a")
    private SelenideElement burgerIcon;

    //локатор кнопки "Конструктор" в хедере
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement designerButton;

    //локатор лейбла "Соберите бургер"
    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']")
    private SelenideElement burgerLabel;

    //локатор кнопки "Булки"
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(1) > span")
    private SelenideElement bunButton;

    //локатор кнопки "Соусы"
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(2) > span")
    private SelenideElement sauceButton;

    //локатор кнопки "Начинки"
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(3) > span")
    private SelenideElement mainButton;

    //локатор раздела "Булки"
    @FindBy(how = How.CSS, using = "div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(2)")
    private SelenideElement bunSection;

    //локатор раздела "Соусы"
    @FindBy(how = How.CSS, using = "div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(4)")
    private SelenideElement sauceSection;

    //локатор раздела "Начинки"
    @FindBy(how = How.CSS, using = "div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(6)")
    private SelenideElement mainSection;

    public boolean checkBunIsDisplayed() {
        return bunSection.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public boolean checkSauceIsDisplayed() {
        return sauceSection.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public boolean checkMainIsDisplayed() {
        return mainSection.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public boolean checkBurgerLabel() {
        return burgerLabel.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public DesignerPage clickBunsButton() {
        bunButton.contextClick();
        return Selenide.page(DesignerPage.class);
    }

    public DesignerPage clickSauceButton() {
        this.sauceButton.click();
        return Selenide.page(DesignerPage.class);
    }

    public DesignerPage clickMainButton() {
        this.mainButton.click();
        return Selenide.page(DesignerPage.class);
    }
}

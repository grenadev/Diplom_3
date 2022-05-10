package ru.stellarburgers.PageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DesignerPage {

    public static String urlOpen = "https://stellarburgers.nomoreparties.site/";

    //локатор икнонки stellarburgers в хедере
    @FindBy(how = How.CSS, using = "header>nav>div>a")
    public SelenideElement burgerIcon;

    //локатор кнопки "Конструктор" в хедере
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    public SelenideElement designerButton;

    //локатор лейбла "Соберите бургер"
    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']")
    public SelenideElement burgerLabel;

    //локатор кнопки "Булки"
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(1) > span")
    public SelenideElement bunButton;

    //локатор кнопки "Соусы"
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(2) > span")
    public SelenideElement sauceButton;

    //локатор кнопки "Начинки"
    @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(3) > span")
    public SelenideElement mainButton;

    //локатор раздела "Булки"
    @FindBy(how = How.CSS, using = "div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(2)")
    public SelenideElement bunSection;

    //локатор раздела "Соусы"
    @FindBy(how = How.CSS, using = "div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(4)")
    public SelenideElement sauceSection;

    //локатор раздела "Начинки"
    @FindBy(how = How.CSS, using = "div.BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(6)")
    public SelenideElement mainSection;

    public DesignerPage clickBunsButton() {
        this.bunButton.contextClick();
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

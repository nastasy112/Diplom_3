package PageObjectClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public final static String mainPageURL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement personalAccountBtn;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement logInToYourAccountBtn;

    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'AppHeader_header__linkText__3q_va')])[1]")
    private SelenideElement constructorBtn;

    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoBtn;

    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    private SelenideElement bunsBtn;

    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    private SelenideElement saucesBtn;

    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    private SelenideElement fillingsBtn;

    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredient_ingredient__text__yp3dH")
    private ElementsCollection ingredientsCollection;

    public LoginPage clickPersonalAccountBtn(){
        personalAccountBtn.scrollIntoView(true);
        personalAccountBtn.click();
        return page(LoginPage.class);
    }

    public AccountPage clickConstructorBtn(){
        constructorBtn.scrollIntoView(true);
        constructorBtn.click();
        return page(AccountPage.class);
    }

    public AccountPage clickLogoBtn(){
        logoBtn.scrollIntoView(true);
        logoBtn.click();
        return page(AccountPage.class);
    }

    public LoginPage clickLogInToYourAccountBtn(){
        logInToYourAccountBtn.scrollIntoView(true);
        logInToYourAccountBtn.click();
        return page(LoginPage.class);
    }

    public MainPage clickBunBtn(){
        bunsBtn.scrollIntoView(true);
        bunsBtn.click();
        return this;
    }

    public MainPage clickSaucesBtn(){
        saucesBtn.scrollIntoView(true);
        saucesBtn.click();
        return this;
    }

    public MainPage clickFillingBtn(){
        fillingsBtn.scrollIntoView(true);
        fillingsBtn.click();
        return this;
    }

    public boolean isGetIngredientsCorrect(int index, String nameIngredients){
        ingredientsCollection.get(index).shouldBe(Condition.visible);
        return ingredientsCollection.get(index).getText().contains(nameIngredients);
    }
}

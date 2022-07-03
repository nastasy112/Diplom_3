package PageObjectClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    @FindBy(how = How.NAME, using = "name")
    private SelenideElement nameInput;

    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement loginSubmit;

    @FindBy(how = How.XPATH, using = ".//a[@href='/register']")
    private SelenideElement signupBtn;

    @FindBy(how = How.XPATH, using = ".//a[@href='/forgot-password']")
    private SelenideElement recoverPasswordBtn;

    public void setName(String name) {
        nameInput.setValue(name);
    }

    public void setPassword(String password) {
        passwordInput.setValue(password);
    }

    public AccountPage clickLoginBtn(){
        loginSubmit.scrollIntoView(true);
        loginSubmit.click();
        return page(AccountPage.class);
    }

    public RecoverPasswordPage clickRecoverPasswordBtn(){
        recoverPasswordBtn.scrollIntoView(true);
        recoverPasswordBtn.click();
        return page(RecoverPasswordPage.class);
    }

    public AccountPage login(String name, String password){
        setName(name);
        setPassword(password);
        clickLoginBtn();
        return page(AccountPage.class);
    }

    public RegistrationPage clickSignupBtn(){
        signupBtn.scrollIntoView(true);
        signupBtn.click();
        return page(RegistrationPage.class);
    }

    public boolean isLoginBtnDisplayed(){
        loginSubmit.scrollIntoView(true);
        loginSubmit.shouldBe(Condition.exist);
        return loginSubmit.isDisplayed();
    }
}

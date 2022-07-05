package page_object_class;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AccountPage {

    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement personalAccountBtn;

    public boolean isCreateOrderBtnDisplayed(){
        createOrderButton.scrollIntoView(true);
        createOrderButton.shouldBe(Condition.exist);
        return createOrderButton.isDisplayed();
    }

    public PersonalAccountPage clickPersonalAccountBtn(){
        personalAccountBtn.scrollIntoView(true);
        personalAccountBtn.click();
        return page(PersonalAccountPage.class);
    }
}

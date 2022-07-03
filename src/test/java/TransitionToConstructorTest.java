import clients.UserClient;
import jdk.jfr.Description;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TransitionToConstructorTest extends BrowserStarter{
    // Переход из личного кабинета в конструктор
    // Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.

    User user;
    UserClient userClient;
    String accessToken;

    @Before
    public void setUp(){
        userClient = new UserClient();
        user = User.getRandom();
        accessToken= userClient.create(user);
    }

    @After
    public void deleteUser(){
        if(accessToken != null) {
            userClient.delete(accessToken);
        }
    }

    @Test
    @Description("Transition to constructor from Account Page via Constructor button")
    public void successTransitionToConstructorFromAccountPageViaConstructorBtn() {
        // нажать кнопку Войти в аккаунт
        // ввести почту и пароль
        // нажать кнопку входа
        // нажать на кнопку личного кабинета
        // нажать на кнопку конструктора
        final boolean isTransitionToConstructorViaConstructorBtnCorrect = mainPage
                .clickLogInToYourAccountBtn()
                .login(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtn()
                .clickConstructorBtn()
                .isCreateOrderBtnDisplayed();
        assertTrue("Переход из личного кабинета в конструтор через кнопку 'Конструктор' не выполнен или выполнен некорректно", isTransitionToConstructorViaConstructorBtnCorrect);
    }

    @Test
    @Description("Transition to constructor from Account Page via logo button")
    public void successTransitionToConstructorFromAccountPageViaLogoBtn() {
        // нажать кнопку Войти в аккаунт
        // ввести почту и пароль
        // нажать кнопку входа
        // нажать на кнопку личного кабинета
        // нажать на логотип
        final boolean isTransitionToConstructorViaLogoBtnCorrect = mainPage
                .clickLogInToYourAccountBtn()
                .login(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtn()
                .clickLogoBtn()
                .isCreateOrderBtnDisplayed();
        assertTrue("Переход из личного кабинета в конструтор при нажатии на логотип не выполнен или выполнен некорректно", isTransitionToConstructorViaLogoBtnCorrect);
    }
}

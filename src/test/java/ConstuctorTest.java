import jdk.jfr.Description;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstuctorTest extends BrowserStarter{
    //Раздел «Конструктор»
    //Проверь, что работают переходы к разделам:
    //«Булки»,
    //«Соусы»,
    //«Начинки».

    @Test
    @Description("checkBuns")
    public void checkBuns() {
        // нажать кнопку Булки
        // проверить отображение ингредиентов - булки
        final boolean isGetBunsCorrect = mainPage
                .isGetIngredientsCorrect(0, "булка");
        assertTrue("Ошибка отображения булок", isGetBunsCorrect);
    }

    @Test
    @Description("checkSauces")
    public void checkSauces() {
        // нажать кнопку Соусы
        // проверить отображение ингредиентов - соусы
        final boolean isGetSaucesCorrect = mainPage
                .clickSaucesBtn()
                .isGetIngredientsCorrect(3, "Соус");
        assertTrue("Ошибка отображения соусов", isGetSaucesCorrect);
    }

    @Test
    @Description("checkFillings")
    public void checkFillings() {
        // нажать кнопку Начинки
        // проверить отображение ингредиентов - начинки
        final boolean isGetFillingsCorrect = mainPage
                .clickFillingBtn()
                .isGetIngredientsCorrect(6, "Мясо");
        assertTrue("Ошибка отображения начинок", isGetFillingsCorrect);
    }
}

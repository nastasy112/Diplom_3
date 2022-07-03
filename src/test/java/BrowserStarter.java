import PageObjectClass.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

import static PageObjectClass.MainPage.mainPageURL;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BrowserStarter {
    MainPage mainPage;

    @Before
    public void startBrowser() {
        //Для прогона через Яндекс раскомментировать!
//        ChromeDriver driver;
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
//        driver = new ChromeDriver();
//        WebDriverRunner.setWebDriver(driver);

        mainPage = Selenide.open(mainPageURL, MainPage.class);
        Configuration.browserSize = "1980x1000";
    }

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }
}

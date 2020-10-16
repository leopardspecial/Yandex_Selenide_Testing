package yandexTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.Weather;
import page.YandexWeatherPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class AlphaYandexTest {
    private final String url = "https://yandex.ru/pogoda/izhevsk";
    private YandexWeatherPage yandexWeatherPage;

    @Before
    public void initStatements() {
        yandexWeatherPage = new YandexWeatherPage(url);
        yandexWeatherPage.openPage();
    }

    @Test
    public void printElementCollection() {
        yandexWeatherPage.printWeather(7);
    }

    @After
    public void closeBrowser() {
        closeWebDriver();
    }
}

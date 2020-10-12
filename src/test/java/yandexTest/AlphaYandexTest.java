package yandexTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.WeatherCollection;
import page.YandexWeatherPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class AlphaYandexTest {
    private final String url = "https://yandex.ru/pogoda/izhevsk";
    private YandexWeatherPage yandexPage;
    private WeatherCollection weatherCollection;

    @Before
    public void createYandexPage() {
        yandexPage = new YandexWeatherPage(url);
    }

    @Before
    public void createWeatherCollection() {
        weatherCollection = new WeatherCollection();
    }

    @Before
    public void openPage() {
        yandexPage.openPage();
    }

    @Test
    public void printElementCollection() {
        yandexPage.printElementCollection(weatherCollection);
    }

    @After
    public void closeBrowser() {
        closeWebDriver();
    }
}

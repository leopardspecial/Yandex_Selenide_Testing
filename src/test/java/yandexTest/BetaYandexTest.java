package yandexTest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class BetaYandexTest {
    private String dayNumberCssSelector;
    private String dayOfMonthCssSelector;
    private String dayOfWeekCssSelector;
    private String dayPartAndTempCssSelector;
    private String dayPartCssSelector;
    private String dayTempCssSelector;
    private ElementsCollection weatherDays;
    private int elementWrapperCounty;
    private List<String> dayNumbersCollection;


    @Before
    public void openYandexPage() {
        open("https://yandex.ru/pogoda/izhevsk");
    }

    @Before
    public void getElementCollectionCounty() {
        weatherDays = $$(By.xpath("//div[@class='card']"));
        elementWrapperCounty = weatherDays.size();
    }

    @Before
    public void setElementsCollections() {
        dayNumberCssSelector = "div[class=card] strong";
        dayOfMonthCssSelector = "small span:nth-of-type(1)";
        dayOfWeekCssSelector = "small span:nth-of-type(2)";
        dayPartAndTempCssSelector = "td:nth-of-type(1)";
        dayPartCssSelector = "div[class=weather-table__wrapper] div:nth-of-type(1)";
        dayTempCssSelector = "div[class=weather-table__wrapper] div:nth-of-type(2)";
    }


    @Test
    public void printElementCollection() {
        for (SelenideElement titleElementOfTable : weatherDays) {
            System.out.println(titleElementOfTable.$(dayNumberCssSelector).getText() + " " +
                    titleElementOfTable.$(dayOfMonthCssSelector).getText() + " " +
                    titleElementOfTable.$(dayOfWeekCssSelector).getText());
            System.out.println("{");
            for (SelenideElement firsColumnElement : titleElementOfTable.$$(dayPartAndTempCssSelector)) {
                System.out.println(" " + firsColumnElement.$(dayPartCssSelector).getText() +
                        " " + firsColumnElement.$(dayTempCssSelector).getText());
            }
            System.out.println("}");

        }

    }

    @After
    public void closeBrowser() {
        closeWebDriver();
    }
}
